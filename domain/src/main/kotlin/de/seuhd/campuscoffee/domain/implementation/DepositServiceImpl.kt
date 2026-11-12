
package de.seuhd.campuscoffee.domain.implementation

import de.seuhd.campuscoffee.domain.exceptions.ValidationException
import de.seuhd.campuscoffee.domain.model.Deposit
import de.seuhd.campuscoffee.domain.ports.api.DepositService
import de.seuhd.campuscoffee.domain.ports.data.DepositDataService
import de.seuhd.campuscoffee.domain.ports.data.UserDataService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

/**
 * Domain implementation of [DepositService].
 * It validates and stores deposits made by users and updates their balances.
 */
@Service
class DepositServiceImpl(
    private val depositDataService: DepositDataService,
    private val userDataService: UserDataService
) : DepositService {
    @Transactional
    override fun create(deposit: Deposit): Deposit {
        if (deposit.amount <= BigDecimal.ZERO) {
            throw ValidationException("The deposit amount must be greater than zero.")
        }

        val userId =
            deposit.user.id ?: throw ValidationException("A deposit must belong to a stored user.")

        val currentUser = userDataService.getById(userId)

        val updatedUser =
            userDataService.upsert(
                currentUser.copy(
                    balance = currentUser.balance.add(deposit.amount)
                )
            )

        return depositDataService.upsert(
            deposit.copy(
                id = null,
                createdAt = null,
                updatedAt = null,
                user = updatedUser
            )
        )
    }
}

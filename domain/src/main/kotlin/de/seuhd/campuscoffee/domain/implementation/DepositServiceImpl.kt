package de.seuhd.campuscoffee.domain.implementation

import de.seuhd.campuscoffee.domain.exceptions.ValidationException
import de.seuhd.campuscoffee.domain.model.Deposit
import de.seuhd.campuscoffee.domain.ports.api.DepositService
import de.seuhd.campuscoffee.domain.ports.data.DepositDataService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

/**
 * Domain implementation of [DepositService].
 * It validates and stores deposits made by users.
 */
@Service
class DepositServiceImpl(
    private val depositDataService: DepositDataService
) : DepositService {
    @Transactional
    override fun create(deposit: Deposit): Deposit {
        if (deposit.amount <= BigDecimal.ZERO) {
            throw ValidationException("The deposit amount must be greater than zero.")
        }

        if (deposit.user.id == null) {
            throw ValidationException("A deposit must belong to a stored user.")
        }

        return depositDataService.upsert(
            deposit.copy(
                id = null,
                createdAt = null,
                updatedAt = null
            )
        )
    }
}

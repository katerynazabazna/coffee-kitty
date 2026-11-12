package de.seuhd.campuscoffee.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

/**
 * Domain model of a deposit made by a user.
 * A deposit increases the user's balance by its amount.
 */
data class Deposit(
    override val id: UUID? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val user: User,
    val amount: BigDecimal
) : DomainModel<UUID>

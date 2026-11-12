package de.seuhd.campuscoffee.api.dtos

import de.seuhd.campuscoffee.domain.model.Deposit
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

/**
 * Response body for a deposit.
 */
data class DepositDto(
    @field:Schema(accessMode = Schema.AccessMode.READ_ONLY)
    override val id: UUID? = null,
    @field:Schema(accessMode = Schema.AccessMode.READ_ONLY)
    val createdAt: LocalDateTime? = null,
    @field:Schema(accessMode = Schema.AccessMode.READ_ONLY)
    val updatedAt: LocalDateTime? = null,
    val loginName: String,
    val amount: BigDecimal
) : Dto<UUID>

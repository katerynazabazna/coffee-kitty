package de.seuhd.campuscoffee.api.dtos

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

/**
 * Request body for creating a deposit.
 */
data class DepositRequestDto(
    @field:NotNull
    @field:DecimalMin("0.01")
    val amount: BigDecimal?
)

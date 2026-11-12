package de.seuhd.campuscoffee.api.controller

import de.seuhd.campuscoffee.api.dtos.DepositDto
import de.seuhd.campuscoffee.api.dtos.DepositRequestDto
import de.seuhd.campuscoffee.api.mapper.DepositDtoMapper
import de.seuhd.campuscoffee.domain.model.Deposit
import de.seuhd.campuscoffee.domain.ports.api.DepositService
import de.seuhd.campuscoffee.domain.ports.api.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import io.swagger.v3.oas.annotations.parameters.RequestBody as ApiRequestBody

/**
 * Controller under `/api/users/{userId}/deposits` that records a deposit for a user.
 */
@Tag(name = "Deposits", description = "Recording user deposits.")
@RestController
@RequestMapping("/users/{userId}/deposits")
class DepositController(
    private val depositService: DepositService,
    private val userService: UserService,
    private val depositDtoMapper: DepositDtoMapper
) {
    /**
     * Records a deposit for the user with [userId].
     *
     * @param userId the id of the user
     * @param dto the deposit amount
     */
    @Operation(summary = "Record a deposit for a user.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    fun create(
        @Parameter(description = "Unique identifier of the user.", required = true)
        @PathVariable userId: UUID,
        @ApiRequestBody(description = "The amount of the deposit.", required = true)
        @RequestBody
        @Valid dto: DepositRequestDto
    ): ResponseEntity<DepositDto> {
        val user = userService.getById(userId)
        val deposit =
            Deposit(
                user = user,
                amount = requireNotNull(dto.amount)
            )
        val created = depositService.create(deposit)
        return ResponseEntity.status(HttpStatus.CREATED).body(depositDtoMapper.toDto(created))
    }
}

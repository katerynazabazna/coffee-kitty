package de.seuhd.campuscoffee.api.mapper

import de.seuhd.campuscoffee.api.dtos.DepositDto
import de.seuhd.campuscoffee.domain.model.Deposit
import org.mapstruct.Mapper
import org.mapstruct.Mapping

/**
 * MapStruct mapper from a [Deposit] to a [DepositDto].
 */
@Mapper(componentModel = "spring")
interface DepositDtoMapper {
    /**
     * Converts [deposit] to a [DepositDto].
     *
     * @param deposit the deposit to convert
     */
    @Mapping(target = "loginName", source = "user.loginName")
    fun toDto(deposit: Deposit): DepositDto
}

package de.seuhd.campuscoffee.data.mapper

import de.seuhd.campuscoffee.data.persistence.entities.DepositEntity
import de.seuhd.campuscoffee.domain.model.Deposit
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget

/**
 * MapStruct mapper between [Deposit] domain objects and [DepositEntity] JPA entities.
 */
@Mapper(componentModel = "spring", uses = [UserEntityMapper::class, EntityReferenceResolver::class])
interface DepositEntityMapper : EntityMapper<Deposit, DepositEntity> {
    @Mapping(target = "user", source = "user.id")
    override fun toEntity(source: Deposit): DepositEntity

    @Mapping(target = "user", source = "user.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    override fun updateEntity(
        source: Deposit,
        @MappingTarget target: DepositEntity
    )
}

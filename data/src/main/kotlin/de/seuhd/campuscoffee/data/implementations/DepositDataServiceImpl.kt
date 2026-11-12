package de.seuhd.campuscoffee.data.implementations

import de.seuhd.campuscoffee.data.mapper.DepositEntityMapper
import de.seuhd.campuscoffee.data.persistence.entities.DepositEntity
import de.seuhd.campuscoffee.data.persistence.repositories.DepositRepository
import de.seuhd.campuscoffee.domain.model.Deposit
import de.seuhd.campuscoffee.domain.ports.data.DepositDataService
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Data adapter that implements the [DepositDataService] port on the deposits table.
 */
@Service
class DepositDataServiceImpl(
    repository: DepositRepository,
    entityMapper: DepositEntityMapper
) : CrudDataServiceImpl<Deposit, DepositEntity, DepositRepository, UUID>(
        repository,
        entityMapper,
        Deposit::class.java
    ),
    DepositDataService

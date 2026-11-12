package de.seuhd.campuscoffee.data.persistence.repositories

import de.seuhd.campuscoffee.data.persistence.entities.DepositEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

/**
 * Spring Data JPA repository for [DepositEntity].
 * Spring Data implements this interface at runtime.
 */
interface DepositRepository : JpaRepository<DepositEntity, UUID>

package de.seuhd.campuscoffee.domain.implementation

import de.seuhd.campuscoffee.domain.ports.data.CoffeeConsumptionDataService
import de.seuhd.campuscoffee.domain.ports.data.DepositDataService
import de.seuhd.campuscoffee.domain.ports.data.UserDataService
import de.seuhd.campuscoffee.domain.ports.internal.DataResetService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

/**
 * Domain implementation of [DataResetService].
 * It deletes consumptions and deposits before users, because they reference users.
 */
@Service
class DataResetServiceImpl(
    private val coffeeConsumptionDataService: CoffeeConsumptionDataService,
    private val depositDataService: DepositDataService,
    private val userDataService: UserDataService
) : DataResetService {
    override fun clearAll() {
        log.warn { "Clearing all data." }
        coffeeConsumptionDataService.clear()
        depositDataService.clear()
        userDataService.clear()
    }

    private companion object {
        private val log = KotlinLogging.logger {}
    }
}

package de.seuhd.campuscoffee.domain.ports.data

import de.seuhd.campuscoffee.domain.model.Deposit
import java.util.UUID

/**
 * Data port for deposits. DepositDataServiceImpl in the data module implements it.
 */
interface DepositDataService : CrudDataService<Deposit, UUID>

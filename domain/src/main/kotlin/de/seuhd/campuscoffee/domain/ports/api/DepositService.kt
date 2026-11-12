package de.seuhd.campuscoffee.domain.ports.api

import de.seuhd.campuscoffee.domain.model.Deposit

/**
 * API port for deposits. The controllers call it to record deposits.
 * DepositServiceImpl in the domain module implements it.
 */
interface DepositService {
    /**
     * Records a deposit and returns the stored deposit.
     *
     * @param deposit the deposit to record
     * @return the stored deposit with its id and timestamps
     */
    fun create(deposit: Deposit): Deposit
}

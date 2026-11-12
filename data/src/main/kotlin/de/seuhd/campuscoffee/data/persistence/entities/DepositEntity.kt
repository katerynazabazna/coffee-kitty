package de.seuhd.campuscoffee.data.persistence.entities

import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal

/**
 * JPA entity of a deposit, which holds the user who made the deposit and the deposited amount.
 */
@jakarta.persistence.Entity
@Table(name = "deposits")
class DepositEntity : Entity() {
    @field:ManyToOne
    @field:JoinColumn(name = "user_id", nullable = false)
    var user: UserEntity? = null

    @field:Column(name = "amount", precision = 10, scale = 2)
    var amount: BigDecimal? = null
}

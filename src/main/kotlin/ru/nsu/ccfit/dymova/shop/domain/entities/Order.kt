package ru.nsu.ccfit.dymova.shop.domain.entities

import java.sql.Timestamp
import java.util.*
import javax.persistence.*

enum class OrderStatus {
    PENDING_PAYMENT,
    PROCESSING,
    COMPLETED,
    CANCELLED
}

@Entity
class Order (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long?,
        var data: Timestamp?,
        var status: OrderStatus?,
        @OneToMany
        var products: MutableList<OrderItem>
){
    constructor() : this(null, null, null, Collections.emptyList())
}

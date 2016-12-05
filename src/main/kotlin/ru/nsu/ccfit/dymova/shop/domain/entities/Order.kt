package ru.nsu.ccfit.dymova.shop.domain.entities

import com.fasterxml.jackson.annotation.JsonTypeInfo
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
@Table(name = "Orders")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
class Order (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long?,
        var data: Timestamp?,
        var status: OrderStatus?,
        @OneToMany(cascade = arrayOf(CascadeType.PERSIST), mappedBy = "order")
        var products: MutableList<OrderItem>
){
    constructor() : this(null, null, null, Collections.emptyList())
    constructor(data: Timestamp, status: OrderStatus?, products: MutableList<OrderItem>)
            : this(null, data, status, products)
}

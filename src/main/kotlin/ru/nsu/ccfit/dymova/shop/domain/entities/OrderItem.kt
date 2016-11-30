package ru.nsu.ccfit.dymova.shop.domain.entities

import javax.persistence.*

@Entity
class OrderItem (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long?,
        @ManyToOne var product: Product?,
        var count: Long?,
        @ManyToOne var order: Order?
){
    constructor() : this(null, null, null, null)
}
package ru.nsu.ccfit.dymova.shop.domain.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class OrderItem (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long?,
        var product: Product?,
        var count:Long?
){
    constructor() :this(null, null, null)
}
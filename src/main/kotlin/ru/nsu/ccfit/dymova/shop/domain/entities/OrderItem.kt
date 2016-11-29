package ru.nsu.ccfit.dymova.shop.domain.entities

import com.fasterxml.jackson.annotation.JsonTypeInfo
import javax.persistence.*

@Entity
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
class OrderItem (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long?,
        @ManyToOne var product: Product?,
        var count:Long?
){
    constructor() :this(null, null, null)
}
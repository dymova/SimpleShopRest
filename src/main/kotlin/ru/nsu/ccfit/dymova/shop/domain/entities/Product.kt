package ru.nsu.ccfit.dymova.shop.domain.entities

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String,
        var description: String,
        var price: BigDecimal?,
        var category: Category?
){
    constructor() : this(null, "", "", null, null)
    constructor(name: String, description: String, price: BigDecimal?) :
            this(null, name, description, price, null)
}


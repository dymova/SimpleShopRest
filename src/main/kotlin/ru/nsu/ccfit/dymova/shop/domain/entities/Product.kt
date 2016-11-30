package ru.nsu.ccfit.dymova.shop.domain.entities

import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.math.BigDecimal
import javax.persistence.*

@Entity
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String,
        var description: String,
        var price: BigDecimal?,
        @ManyToOne(fetch = FetchType.EAGER) var category: Category?
){
    constructor() : this(null, "", "", null, null)
    constructor(name: String, description: String, price: BigDecimal?, category: Category?) :
            this(null, name, description, price, category)
}


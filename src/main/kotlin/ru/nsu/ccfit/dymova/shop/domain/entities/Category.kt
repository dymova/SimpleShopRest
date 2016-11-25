package ru.nsu.ccfit.dymova.shop.domain.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Category(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String
) {
    constructor() : this(null, "")
    constructor(name: String) : this(null, name)
}
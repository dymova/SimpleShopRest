package ru.nsu.ccfit.dymova.shop.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.ccfit.dymova.shop.domain.OrderRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Order

@RestController
@RequestMapping("/entities/Order")
class OrderController {
    @Autowired
    private lateinit var repository: OrderRepository

    @RequestMapping
    fun get(): MutableIterable<Order>? = repository.findAll()
}
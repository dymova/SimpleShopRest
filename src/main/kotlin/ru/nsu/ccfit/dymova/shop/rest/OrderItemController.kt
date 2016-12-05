package ru.nsu.ccfit.dymova.shop.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import ru.nsu.ccfit.dymova.shop.domain.OrderItemRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.OrderItem

@Controller
class OrderItemController {
    @Autowired
    private lateinit var repository: OrderItemRepository

    /**
     * Gets list of existing order items (count of each product)
     */
    @ResponseBody
    @RequestMapping("/entities/OrderItem")
    fun get(): MutableIterable<OrderItem>? = repository.findAll()
}
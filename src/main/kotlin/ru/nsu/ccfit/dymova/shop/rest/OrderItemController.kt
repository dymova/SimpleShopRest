package ru.nsu.ccfit.dymova.shop.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import ru.nsu.ccfit.dymova.shop.domain.OrderItemRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.OrderItem

@Controller
class OrderItemController {
    @Autowired
    private lateinit var repository: OrderItemRepository

    @RequestMapping("/entities/OrderItem")
    @ResponseBody
    fun get(): MutableIterable<OrderItem>? = repository.findAll()

    @RequestMapping("/OrderItems")
    fun getOrderItems(model: Model): String {
        model.addAttribute("orderItems", repository.findAll())
        return "orderItems"
    }
}
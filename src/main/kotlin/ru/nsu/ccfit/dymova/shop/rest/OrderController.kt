package ru.nsu.ccfit.dymova.shop.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import ru.nsu.ccfit.dymova.shop.domain.OrderRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Order

@Controller
class OrderController {
    @Autowired
    private lateinit var repository: OrderRepository

    @RequestMapping("/entities/Order")
    @ResponseBody
    /**
     * Gets list of existing orders
     */
    @RequestMapping
    fun get(): MutableIterable<Order>? = repository.findAll()

    @RequestMapping("/Orders")
    fun getOrders(model: Model): String {
        model.addAttribute("orders", repository.findAll())
        return "orders"
    }
}
package ru.nsu.ccfit.dymova.shop.ui

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import ru.nsu.ccfit.dymova.shop.domain.OrderRepository

@Controller
class OrderController {
    @Autowired
    private lateinit var orderRepository: OrderRepository

    @RequestMapping("/Orders")
    fun getOrders(model: Model): String {
        model.addAttribute("orders", orderRepository.findAll())
        return "orders"
    }

}
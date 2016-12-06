package ru.nsu.ccfit.dymova.shop.restapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.nsu.ccfit.dymova.shop.domain.OrderRepository
import ru.nsu.ccfit.dymova.shop.domain.ProductRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Order
import ru.nsu.ccfit.dymova.shop.domain.entities.OrderItem
import ru.nsu.ccfit.dymova.shop.domain.entities.OrderStatus
import java.sql.Timestamp
import java.util.*

@RequestMapping("/entities/Order")
@RestController
class OrderApi {
    @Autowired
    private lateinit var orderRepository: OrderRepository

    @Autowired
    private lateinit var productRepository: ProductRepository

    /**
     * Gets list of existing orders
     */
    @ResponseBody
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun get(): MutableIterable<Order>? = orderRepository.findAll()
//    val mapper = ObjectMapper()
//    mapper.writeValueAsString(CreateOrderRequest(mutableListOf(Pair(1L,22L), Pair(2L, 33L))))



    /**
     * Creates new order
     */
    @ResponseBody
    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun createOrder(@RequestBody createOrderRequest: CreateOrderRequest) : Order {
        val orderItems = mutableListOf<OrderItem>()
        for (orderItem in createOrderRequest.orderItems) {
            val product = productRepository.findOne(orderItem.first)

            if (product != null) {
                val count = orderItem.second
                orderItems.add(OrderItem(product, count))
            }
        }
        val data = Timestamp(System.currentTimeMillis())
        return orderRepository.save(Order(data, OrderStatus.PENDING_PAYMENT, orderItems))
    }
}

/**
 * @param orderItems contains ids of products and count of each product
 */
data class CreateOrderRequest(var orderItems: MutableList<Pair<Long, Long>>) {
    constructor() : this(Collections.emptyList())
}

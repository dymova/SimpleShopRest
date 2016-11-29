package ru.nsu.ccfit.dymova.shop

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import ru.nsu.ccfit.dymova.shop.domain.CategoryRepository
import ru.nsu.ccfit.dymova.shop.domain.OrderRepository
import ru.nsu.ccfit.dymova.shop.domain.ProductRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.*
import java.math.BigDecimal
import java.sql.Timestamp

@SpringBootApplication
open class Application {
    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Autowired
    private lateinit var orderRepository: OrderRepository


    @Bean
    open fun init() = org.springframework.boot.CommandLineRunner {
        val foodCategory = categoryRepository.save(Category("food"))
        val product = productRepository.save(Product("milk", "fresh milk", BigDecimal(56), foodCategory))
        productRepository.save(Product("bread", "bread for toasts", BigDecimal(34), foodCategory))

        val orderItem = OrderItem(null, product, 42)
        orderRepository.save(Order(null, Timestamp(System.currentTimeMillis()),
                OrderStatus.PENDING_PAYMENT, mutableListOf(orderItem)))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

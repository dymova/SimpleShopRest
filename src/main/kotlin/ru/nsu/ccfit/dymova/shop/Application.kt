package ru.nsu.ccfit.dymova.shop

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import ru.nsu.ccfit.dymova.shop.domain.ProductRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Product
import java.math.BigDecimal

@SpringBootApplication
open class Application {
    @Autowired
    private lateinit var repository: ProductRepository

    @Bean
    open fun init() = org.springframework.boot.CommandLineRunner {
        repository.save(Product("milk", "fresh milk", BigDecimal(56)))
        repository.save(Product("bread", "bread for toasts", BigDecimal(34)))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

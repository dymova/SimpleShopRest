package ru.nsu.ccfit.dymova.shop.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.ccfit.dymova.shop.domain.ProductRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Product

@RestController
class ProductController {
    @Autowired
    private lateinit var repository: ProductRepository

    @RequestMapping("/product")
    fun getProducts(): MutableIterable<Product>? = repository.findAll()

}
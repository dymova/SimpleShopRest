package ru.nsu.ccfit.dymova.shop.restapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import ru.nsu.ccfit.dymova.shop.domain.ProductRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Product
@RequestMapping("/entities/Product")
@RestController
class ProductApi {
    @Autowired
    private lateinit var repository: ProductRepository

    /**
     * Gets list of existing products
     */
    @ResponseBody
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun get(): MutableIterable<Product>? = repository.findAll()
}
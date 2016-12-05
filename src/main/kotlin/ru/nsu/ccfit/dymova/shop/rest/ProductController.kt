package ru.nsu.ccfit.dymova.shop.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import ru.nsu.ccfit.dymova.shop.domain.ProductRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Product

@Controller
class ProductController {
    @Autowired
    private lateinit var repository: ProductRepository

    /**
     * Gets list of existing products
     */
    @ResponseBody
    @RequestMapping("/entities/Product")
    fun get(): MutableIterable<Product>? = repository.findAll()

    @RequestMapping("/Products")
    fun getProducts(model: Model): String {
        model.addAttribute("products", repository.findAll())
        return "products"
    }

}
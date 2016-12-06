package ru.nsu.ccfit.dymova.shop.ui

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import ru.nsu.ccfit.dymova.shop.domain.ProductRepository

@Controller
class ProductController {
    @Autowired
    private lateinit var repository: ProductRepository


    @RequestMapping("/Products")
    fun getProducts(model: Model): String {
        model.addAttribute("products", repository.findAll())
        return "products"
    }

}
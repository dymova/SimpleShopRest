package ru.nsu.ccfit.dymova.shop.ui

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import ru.nsu.ccfit.dymova.shop.domain.CategoryRepository

@Controller
class CategoryController {
    @Autowired
    private lateinit var repository: CategoryRepository

    @RequestMapping("/Categories")
    fun getCategories(model: Model): String {
        model.addAttribute("categories", repository.findAll())
        return "categories"
    }
}
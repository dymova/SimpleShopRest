package ru.nsu.ccfit.dymova.shop.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import ru.nsu.ccfit.dymova.shop.domain.CategoryRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Category

@Controller
class CategoryController {
    @Autowired
    private lateinit var repository: CategoryRepository

    /**
     * Gets list of existing categories
     */
    @ResponseBody
    @RequestMapping("/entities/Category")
    fun get(): MutableIterable<Category>? = repository.findAll()

    @RequestMapping("/Categories")
    fun getCategories(model: Model): String {
        model.addAttribute("categories", repository.findAll())
        return "categories"
    }
}
package ru.nsu.ccfit.dymova.shop.restapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import ru.nsu.ccfit.dymova.shop.domain.CategoryRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Category

@RequestMapping("/entities/Category")
@RestController
class CategoryApi {
    @Autowired
    private lateinit var repository: CategoryRepository
    /**
     * Gets list of existing categories
     */
    @ResponseBody
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun get(): MutableIterable<Category>? = repository.findAll()

}
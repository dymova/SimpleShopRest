package ru.nsu.ccfit.dymova.shop.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.nsu.ccfit.dymova.shop.domain.CategoryRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Category

@RestController
@RequestMapping("/entities/Category")
class CategoryController {
    @Autowired
    private lateinit var repository: CategoryRepository

    @RequestMapping
    fun get(): MutableIterable<Category>? = repository.findAll()

}
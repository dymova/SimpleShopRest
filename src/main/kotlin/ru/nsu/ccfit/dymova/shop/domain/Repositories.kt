package ru.nsu.ccfit.dymova.shop.domain

import org.springframework.data.repository.CrudRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Category
import ru.nsu.ccfit.dymova.shop.domain.entities.Order
import ru.nsu.ccfit.dymova.shop.domain.entities.Product

interface ProductRepository : CrudRepository<Product, Long>
interface CategoryRepository : CrudRepository<Category, Long>
interface OrderRepository : CrudRepository<Order, Long>


package ru.cib.muamstart.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.cib.muamstart.dao.Category
import ru.cib.muamstart.dao.Product

interface ProductRepository : JpaRepository<Product, Long> {
    fun findAllByCategory(category: Category): List<Product>
}
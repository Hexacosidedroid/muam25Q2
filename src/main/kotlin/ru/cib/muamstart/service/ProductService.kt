package ru.cib.muamstart.service

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.cib.muamstart.dao.Category
import ru.cib.muamstart.dao.Product
import ru.cib.muamstart.repository.CategoryRepository
import ru.cib.muamstart.repository.ProductRepository

@Service
class ProductService(
    private val restTemplate: RestTemplate,
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) {
    fun getAllListOfProducts(): List<Product> = productRepository.findAll()
    fun getAllListOfCategories(): List<Category> = categoryRepository.findAll()
}
package ru.cib.muamstart.service

import com.github.javafaker.Faker
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.cib.muamstart.dao.Product

@Service
class ProductService(
    private val restTemplate: RestTemplate,
) {

    fun getAllListOfProducts(): MutableList<Product> {
        return mutableListOf(
            Product().apply {
                id = 0
                name = Faker.instance().funnyName().name()
                description = Faker.instance().chuckNorris().fact()
                price = 0.0
                quantity = 0
        })
    }

}
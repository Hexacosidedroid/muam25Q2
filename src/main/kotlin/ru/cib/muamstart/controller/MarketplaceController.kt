package ru.cib.muamstart.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.cib.muamstart.dao.Product
import ru.cib.muamstart.dao.User
import ru.cib.muamstart.service.ProductService
import ru.cib.muamstart.service.UserService

@RestController
class MarketplaceController(
    private val productService: ProductService,
    private val userService: UserService
) {

    @GetMapping("/api")
    fun getApiVersion() = "1.0"

    @GetMapping("/products")
    fun getAllProducts(): List<Product> {
        val result = productService.getAllListOfProducts()
        return result
    }

//    @GetMapping("/getUserByLogin={login}")
//    fun getUserByLogin(@PathVariable login: String): User {
//      val result = userService.getUserByLogin(login)
//      return result
//    }



    /*
    * 3. корзина
    * */
}
package ru.cib.muamstart.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.cib.muamstart.dao.Product
import ru.cib.muamstart.service.ProductService
import ru.cib.muamstart.service.UserService
import java.util.UUID

@RestController
class MarketplaceController(
    private val productService: ProductService,
    private val userService: UserService
) {

    @GetMapping("/v1/products/all")
    fun getAllProducts(): List<Product> {
        val result = productService.getAllListOfProducts()
        return result
    }

    @GetMapping("/v2/products/all={id}")
    fun getAllProductsV2(@PathVariable id: Int): List<Product> {
        val result = productService.getAllListOfProductsV2(id.toLong())
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
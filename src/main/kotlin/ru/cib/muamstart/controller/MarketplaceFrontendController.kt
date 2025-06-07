package ru.cib.muamstart.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import ru.cib.muamstart.service.ProductService

@Controller
class MarketplaceFrontendController(
    private val productService: ProductService
) {

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("title", "Главная страница")
        return "index"
    }

    @GetMapping("/products")
    fun products(model: Model): String {
        val allListOfProducts = productService.getAllListOfProducts()
        val totalProducts = allListOfProducts.size
        val totalSellers = allListOfProducts.distinctBy { it.seller?.id }.size
        model.addAttribute("totalSellers", totalSellers)
        model.addAttribute("products", allListOfProducts)
        model.addAttribute("totalProducts", totalProducts)
        return "products"
    }
}
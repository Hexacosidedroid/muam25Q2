package ru.cib.muamstart.dao

data class Product(
    var id: Int? = null,
    var name: String? = null,
    var description: String? = null,
    var price: Double? = null,
    var quantity: Int? = null
)

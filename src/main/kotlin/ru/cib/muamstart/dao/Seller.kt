package ru.cib.muamstart.dao

// Продавцы
data class Seller(
    val sellerId: Int = 0,
    val userId: Int,
    val companyName: String? = null,
    val taxId: String? = null,
    val bankDetails: String? = null
)
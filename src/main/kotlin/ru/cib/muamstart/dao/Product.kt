package ru.cib.muamstart.dao

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "products")
data class Product(
    @Id
    val productId: Int = 0,
    val sellerId: Int,
    val categoryId: Int,
    val title: String,
    val description: String? = null,
    val price: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val stockQuantity: Int = 0,
    val isActive: Boolean = true
)
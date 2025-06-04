package ru.cib.muamstart.dao

import java.math.BigDecimal
import java.time.LocalDateTime

data class Order(
    val orderId: Int = 0,
    val userId: Int,
    val status: String = "PENDING", // PENDING, PAID, SHIPPED, DELIVERED, CANCELLED
    val totalAmount: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
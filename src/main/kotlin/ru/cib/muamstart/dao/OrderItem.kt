package ru.cib.muamstart.dao

import java.math.BigDecimal

data class OrderItem(
    val orderItemId: Int = 0,
    val orderId: Int,
    val productId: Int,
    val quantity: Int,
    val price: BigDecimal
)


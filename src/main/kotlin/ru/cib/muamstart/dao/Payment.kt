package ru.cib.muamstart.dao

import java.math.BigDecimal
import java.time.LocalDateTime

data class Payment(
    val paymentId: Int = 0,
    val orderId: Int,
    val amount: BigDecimal,
    val method: String, // CARD, PAYPAL, APPLE_PAY
    val transactionId: String,
    val status: String, // PENDING, COMPLETED, FAILED
    val createdAt: LocalDateTime = LocalDateTime.now()
)
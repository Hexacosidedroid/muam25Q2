package ru.cib.muamstart.dao

import java.time.LocalDateTime

data class Review(
    val reviewId: Int = 0,
    val productId: Int,
    val userId: Int,
    val rating: Int, // 1-5
    val comment: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

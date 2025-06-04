package ru.cib.muamstart.dao

import java.time.LocalDateTime

data class User(
    val userId: Int = 0,
    val email: String,
    val passwordHash: String,
    val fullName: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val isSeller: Boolean = false
)

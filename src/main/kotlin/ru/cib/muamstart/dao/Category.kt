package ru.cib.muamstart.dao

data class Category(
    val categoryId: Int = 0,
    val name: String,
    val parentId: Int? = null
)
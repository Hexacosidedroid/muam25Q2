package ru.cib.muamstart.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.cib.muamstart.dao.Category

interface CategoryRepository: JpaRepository<Category, Long> {
}
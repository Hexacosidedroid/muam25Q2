package ru.cib.muamstart.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.cib.muamstart.dao.Category
import ru.cib.muamstart.dao.Order
import ru.cib.muamstart.dao.OrderItem
import ru.cib.muamstart.dao.Product

interface OrderItemRepository : JpaRepository<OrderItem, Long> {
}
package ru.cib.muamstart.rowmappers

import org.springframework.jdbc.core.RowMapper
import ru.cib.muamstart.dao.Product
import java.sql.ResultSet
import java.time.LocalDateTime

class ProductRowMapper : RowMapper<Product> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Product {
        return Product(
            productId = rs.getInt("product_id"),
            sellerId = rs.getInt("seller_id"),
            categoryId = rs.getInt("category_id"),
            title = rs.getString("title"),
            description = rs.getString("description"),
            price = rs.getBigDecimal("price"),
            createdAt = rs.getObject("created_at", LocalDateTime::class.java),
            stockQuantity = rs.getInt("stock_quantity"),
            isActive = rs.getBoolean("is_active")
        )
    }
}
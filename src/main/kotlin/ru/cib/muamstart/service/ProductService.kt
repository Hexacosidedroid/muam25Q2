package ru.cib.muamstart.service

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForList
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.cib.muamstart.dao.Product
import ru.cib.muamstart.rowmappers.ProductRowMapper

@Service
class ProductService(
    private val jdbcTemplate: JdbcTemplate,
    private val restTemplate: RestTemplate,
) {
    fun getAllListOfProducts(): List<Product> = jdbcTemplate.query("select * from products", ProductRowMapper())
}
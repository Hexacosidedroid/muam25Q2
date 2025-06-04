package ru.cib.muamstart.service

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import ru.cib.muamstart.dao.User
import java.util.UUID

@Service
class UserService(
    private val jdbcTemplate: JdbcTemplate
) {

//    fun getUserByLogin(login: String): User {
//        val user = User().apply {
//            id = Faker.instance().idNumber().valid()
//            username = login
//            password = UUID.randomUUID().toString()
//            email = Faker.instance().chuckNorris().fact()
//        }
//        return user
//    }
}
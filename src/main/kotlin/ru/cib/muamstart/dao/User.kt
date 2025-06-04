package ru.cib.muamstart.dao

data class User(
    var id: String? = null,
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var walletCurrency: Int? = null,
)

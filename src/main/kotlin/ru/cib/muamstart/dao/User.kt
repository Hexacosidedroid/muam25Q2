package ru.cib.muamstart.dao

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(
    name = "users", schema = "public", uniqueConstraints = [
        UniqueConstraint(name = "users_email_key", columnNames = ["email"])
    ]
)
data class User (
    @Id
    @ColumnDefault("nextval('users_user_id_seq')")
    @Column(name = "user_id", nullable = false)
    var id: Int? = null,

    @Column(name = "email", nullable = false)
    var email: String? = null,

    @Column(name = "password_hash", nullable = false)
    var passwordHash: String? = null,

    @Column(name = "full_name", nullable = false, length = 100)
    var fullName: String? = null,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant? = null,

    @ColumnDefault("false")
    @Column(name = "is_seller", nullable = false)
    var isSeller: Boolean? = false
)
package ru.cib.muamstart.dao

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(
    name = "orders", schema = "public", indexes = [
        Index(name = "idx_orders_user", columnList = "user_id")
    ]
)
data class Order(
    @Id
    @ColumnDefault("nextval('orders_order_id_seq')")
    @Column(name = "order_id", nullable = false)
    var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null,

    @ColumnDefault("'PENDING'")
    @Column(name = "status", nullable = false, length = 20)
    var status: String? = null,

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    var totalAmount: BigDecimal? = null,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant? = null,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    var updatedAt: Instant? = null
)
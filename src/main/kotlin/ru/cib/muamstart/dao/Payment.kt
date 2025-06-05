package ru.cib.muamstart.dao

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(
    name = "payments", schema = "public", uniqueConstraints = [
        UniqueConstraint(name = "payments_order_id_key", columnNames = ["order_id"]),
        UniqueConstraint(name = "payments_transaction_id_key", columnNames = ["transaction_id"])
    ]
)
data class Payment (
    @Id
    @ColumnDefault("nextval('payments_payment_id_seq')")
    @Column(name = "payment_id", nullable = false)
    var id: Int? = null,

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "order_id", nullable = false)
    var order: Order? = null,

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    var amount: BigDecimal? = null,

    @Column(name = "method", nullable = false, length = 20)
    var method: String? = null,

    @Column(name = "transaction_id", nullable = false, length = 100)
    var transactionId: String? = null,

    @Column(name = "status", nullable = false, length = 20)
    var status: String? = null,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant? = null
)
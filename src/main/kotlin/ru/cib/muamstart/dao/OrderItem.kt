package ru.cib.muamstart.dao

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "order_items", schema = "public")
data class OrderItem(
    @Id
    @ColumnDefault("nextval('order_items_order_item_id_seq')")
    @Column(name = "order_item_id", nullable = false)
    var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "order_id", nullable = false)
    var order: Order? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product? = null,

    @Column(name = "quantity", nullable = false)
    var quantity: Int? = null,

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    var price: BigDecimal? = null
)
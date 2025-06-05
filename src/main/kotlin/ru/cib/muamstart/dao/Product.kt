package ru.cib.muamstart.dao

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import ru.cib.muamstart.dao.Category
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "products", schema = "public")
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('products_product_id_seq')")
    @Column(name = "product_id", nullable = false)
    var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "seller_id", nullable = false)
    var seller: Seller? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "category_id", nullable = false)
    var category: Category? = null,

    @Column(name = "title", nullable = false, length = 200)
    var title: String? = null,

    @Column(name = "description", length = Integer.MAX_VALUE)
    var description: String? = null,

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    var price: BigDecimal? = null,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant? = null,

    @ColumnDefault("0")
    @Column(name = "stock_quantity", nullable = false)
    var stockQuantity: Int? = null,

    @ColumnDefault("true")
    @Column(name = "is_active", nullable = false)
    var isActive: Boolean? = false
)
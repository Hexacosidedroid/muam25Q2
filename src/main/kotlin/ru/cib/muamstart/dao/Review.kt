package ru.cib.muamstart.dao

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(
    name = "reviews", schema = "public", indexes = [
        Index(name = "idx_reviews_product", columnList = "product_id")
    ], uniqueConstraints = [
        UniqueConstraint(name = "reviews_product_id_user_id_key", columnNames = ["product_id", "user_id"])
    ]
)
data class Review (
    @Id
    @ColumnDefault("nextval('reviews_review_id_seq')")
    @Column(name = "review_id", nullable = false)
    var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null,

    @Column(name = "rating", nullable = false)
    var rating: Short? = null,

    @Column(name = "comment", length = Integer.MAX_VALUE)
    var comment: String? = null,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant? = null
)
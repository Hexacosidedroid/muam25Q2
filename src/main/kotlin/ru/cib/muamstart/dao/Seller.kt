package ru.cib.muamstart.dao

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(
    name = "sellers", schema = "public", uniqueConstraints = [
        UniqueConstraint(name = "sellers_user_id_key", columnNames = ["user_id"])
    ]
)
data class Seller ( 
    @Id
    @ColumnDefault("nextval('sellers_seller_id_seq')")
    @Column(name = "seller_id", nullable = false)
    var id: Int? = null,

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null,

    @Column(name = "company_name", length = 100)
    var companyName: String? = null,

    @Column(name = "tax_id", length = 30)
    var taxId: String? = null,

    @Column(name = "bank_details", length = Integer.MAX_VALUE)
    var bankDetails: String? = null
)
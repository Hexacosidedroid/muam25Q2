package ru.cib.muamstart.dao

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(
    name = "categories", schema = "public", uniqueConstraints = [
        UniqueConstraint(name = "categories_name_key", columnNames = ["name"])
    ]
)
data class Category (
    @Id
    @ColumnDefault("nextval('categories_category_id_seq')")
    @Column(name = "category_id", nullable = false)
    var id: Int? = null,

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "parent_id")
    var parent: Category? = null
)
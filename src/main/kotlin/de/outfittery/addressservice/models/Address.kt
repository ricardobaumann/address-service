package de.outfittery.addressservice.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "addresses")
data class Address(
        @Id val id: Long? = null,
        val text: String? = null
)
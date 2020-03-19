package de.outfittery.addressservice.models

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "addresses")
data class Address(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @field:NotNull val customerId: Long = 1L,
        @field:NotBlank val firstName: String = "",
        @field:NotBlank val lastName: String = "",
        @field:NotBlank val street: String = "",
        val co: String? = null,
        val coType: String? = null,
        @field:NotBlank val streetNumber: String = "",
        val additionToAddress: String? = null,
        @field:NotBlank val zip: String = "",
        @field:NotBlank val country: String = "",
        val defaultShippingAddress: Boolean = false,
        val defaultBillingAddress: Boolean = false,
        @CreatedDate var createdAt: Date? = null,
        @LastModifiedDate var updatedAt: Date? = null
)
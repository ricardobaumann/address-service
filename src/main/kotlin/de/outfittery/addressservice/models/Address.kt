package de.outfittery.addressservice.models

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "addresses")
data class Address(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @NotNull val text: String? = null,
        @NotNull val customerId: Long? = null,
        @CreatedDate var createdAt: Date? = null,
        @LastModifiedDate var updatedAt: Date? = null
)
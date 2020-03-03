package de.outfittery.addressservice.models

import de.outfittery.addressservice.dtos.AddressEventDto
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "address_events")
data class AddressEvent(
        @Id val id: String? = null,
        @NotNull @ManyToOne val address: Address? = null,
        @NotNull @Convert(converter = AddressContentConverter::class) val content: AddressEventDto? = null
)
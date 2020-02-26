package de.outfittery.addressservice.models

import de.outfittery.addressservice.events.AddressEventDto
import java.util.*
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "address_events")
data class AddressEvent(
        @Id val id: String = UUID.randomUUID().toString(),
        @NotNull @Convert(converter = AddressContentConverter::class) val content: AddressEventDto? = null
)
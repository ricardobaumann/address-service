package de.outfittery.addressservice.models

import de.outfittery.addressservice.dtos.AddressValidationResult
import java.util.*
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "address_validation_events")
data class AddressValidationEvent(
        @Id val id: String = UUID.randomUUID().toString(),
        @NotNull @Convert(converter = AddressValidationResultConverter::class) val content: AddressValidationResult? = null
)
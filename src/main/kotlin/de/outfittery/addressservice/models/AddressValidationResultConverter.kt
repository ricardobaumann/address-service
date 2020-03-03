package de.outfittery.addressservice.models

import com.fasterxml.jackson.databind.ObjectMapper
import de.outfittery.addressservice.dtos.AddressValidationResult
import org.springframework.stereotype.Component
import javax.persistence.AttributeConverter

@Component
class AddressValidationResultConverter(private val objectMapper: ObjectMapper) : AttributeConverter<AddressValidationResult, String> {

    override fun convertToDatabaseColumn(attribute: AddressValidationResult?) = attribute?.let { objectMapper.writeValueAsString(it) }

    override fun convertToEntityAttribute(dbData: String?) = dbData?.let { objectMapper.readValue(it, AddressValidationResult::class.java) }

}

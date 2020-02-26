package de.outfittery.addressservice.models

import com.fasterxml.jackson.databind.ObjectMapper
import de.outfittery.addressservice.events.AddressEventDto
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class AddressContentConverter(private val objectMapper: ObjectMapper) : AttributeConverter<AddressEventDto, String> {

    override fun convertToDatabaseColumn(attribute: AddressEventDto?) = attribute?.let {
        objectMapper.writeValueAsString(it)
    }

    override fun convertToEntityAttribute(dbData: String?) = dbData?.let {
        objectMapper.readValue(it, AddressEventDto::class.java)
    }
}
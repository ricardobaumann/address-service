package de.outfittery.addressservice.service.validation

import de.outfittery.addressservice.dtos.AddressValidationEventDto
import de.outfittery.addressservice.dtos.AddressValidationResult
import de.outfittery.addressservice.events.AddressValidationResultPublisher
import de.outfittery.addressservice.models.Address
import org.springframework.stereotype.Service

@Service
class AddressValidationService(private val addressValidationResultPublisher: AddressValidationResultPublisher) {

    fun validate(address: Address) = AddressValidationResult().also {
        addressValidationResultPublisher.publish(AddressValidationEventDto(address = address, addressValidationResult = it))
    }

}
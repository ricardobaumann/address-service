package de.outfittery.addressservice.events

import de.outfittery.addressservice.dtos.AddressValidationEventDto
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class AddressValidationResultPublisher(private val applicationEventPublisher: ApplicationEventPublisher) {

    fun publish(addressValidationEventDto: AddressValidationEventDto) {
        applicationEventPublisher.publishEvent(addressValidationEventDto)
    }

}
package de.outfittery.addressservice.events

import de.outfittery.addressservice.dtos.AddressEventDto
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class AddressEventPublisher(private val applicationEventPublisher: ApplicationEventPublisher) {

    fun publish(addressEventDto: AddressEventDto) {
        applicationEventPublisher.publishEvent(addressEventDto)
    }
}
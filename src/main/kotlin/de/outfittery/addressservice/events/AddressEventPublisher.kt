package de.outfittery.addressservice.events

import de.outfittery.addressservice.models.Address
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class AddressEventPublisher(private val applicationEventPublisher: ApplicationEventPublisher) {

    fun publish(address: Address) {
        applicationEventPublisher.publishEvent(AddressEventDto(address))
    }
}
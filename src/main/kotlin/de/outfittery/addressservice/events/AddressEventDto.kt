package de.outfittery.addressservice.events

import de.outfittery.addressservice.models.Address
import org.springframework.context.ApplicationEvent

data class AddressEventDto(val address: Address) : ApplicationEvent(address)
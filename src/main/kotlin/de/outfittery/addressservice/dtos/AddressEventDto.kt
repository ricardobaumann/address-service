package de.outfittery.addressservice.dtos

import de.outfittery.addressservice.models.Address
import org.springframework.context.ApplicationEvent
import java.util.*

data class AddressEventDto(val address: Address, val id: String = UUID.randomUUID().toString()) : ApplicationEvent(address)
package de.outfittery.addressservice.dtos

import de.outfittery.addressservice.models.Address

data class AddressValidationEventDto(
        val address: Address,
        val addressValidationResult: AddressValidationResult
)
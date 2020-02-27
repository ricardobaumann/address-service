package de.outfittery.addressservice.dtos

import de.outfittery.addressservice.models.Address

data class AddressCreationResult(
        val address: Address? = null,
        val addressValidationResult: AddressValidationResult
)
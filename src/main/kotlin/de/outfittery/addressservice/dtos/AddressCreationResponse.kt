package de.outfittery.addressservice.dtos

data class AddressCreationResponse(
        val id: Long?,
        val addressValidationResult: AddressValidationResult
)
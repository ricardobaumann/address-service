package de.outfittery.addressservice.dtos

data class AddressCreationResponse(
        val id: Long?,
        val correctionList: List<AddressValidationCommand>? = listOf(),
        val success: Boolean?
)
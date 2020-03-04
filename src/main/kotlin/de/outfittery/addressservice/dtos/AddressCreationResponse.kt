package de.outfittery.addressservice.dtos

data class AddressCreationResponse(
        val id: Long?,
        val correctionList: List<String> = listOf(),
        val success: Boolean
)
package de.outfittery.addressservice.dtos

data class AddressValidationResult(
        val status: Int = 0,
        val correctionList: List<String> = listOf()
) {
    fun isSuccess(): Boolean = true
}
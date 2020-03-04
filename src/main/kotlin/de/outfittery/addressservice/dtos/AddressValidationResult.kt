package de.outfittery.addressservice.dtos

data class AddressValidationResult(
        val addressValidationCommand: AddressValidationCommand,
        val status: Int = 0,
        val correctionList: List<String> = listOf()
) {
    fun isSuccess(): Boolean = true
}
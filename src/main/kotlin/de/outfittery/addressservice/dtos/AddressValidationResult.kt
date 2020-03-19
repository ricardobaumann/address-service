package de.outfittery.addressservice.dtos

data class AddressValidationResult(
        val addressValidationCommand: AddressValidationCommand,
        val status: AddressValidationStatus = AddressValidationStatus.INVALID,
        val correctionList: List<AddressValidationCommand> = listOf()
) {
    fun isSuccess(): Boolean = true
}

enum class AddressValidationStatus {
    VALID, INVALID
}
package de.outfittery.addressservice.dtos

import com.fasterxml.jackson.databind.ObjectMapper
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AddressCreateCommand(
        @field:NotNull val customerId: Long? = null,
        @field:NotBlank val firstName: String? = null,
        @field:NotBlank val lastName: String? = null,
        @field:NotBlank val street: String? = null,
        val co: String? = null,
        val coType: String? = null,
        @field:NotBlank val streetNumber: String? = null,
        val additionToAddress: String? = null,
        @field:NotBlank val zip: String? = null,
        @field:NotBlank val country: String? = null,
        val defaultShippingAddress: Boolean = false,
        val defaultBillingAddress: Boolean = false
)

fun main() {
    println(ObjectMapper().writeValueAsString(AddressCreateCommand(
            customerId = 123,
            firstName = "Address",
            lastName = "Service",
            street = "Addessstrasse",
            streetNumber = "7A",
            co = "Address man",
            coType = "COMPANY",
            additionToAddress = "take care with my package",
            zip = "12207",
            country = "DE",
            defaultShippingAddress = true,
            defaultBillingAddress = true
    )))
}
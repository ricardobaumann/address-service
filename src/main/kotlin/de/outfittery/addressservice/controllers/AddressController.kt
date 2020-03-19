package de.outfittery.addressservice.controllers

import de.outfittery.addressservice.dtos.AddressCreateCommand
import de.outfittery.addressservice.dtos.AddressCreationResponse
import de.outfittery.addressservice.dtos.AddressCreationResult
import de.outfittery.addressservice.models.Address
import de.outfittery.addressservice.service.AddressService
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/addresses")
class AddressController(private val addressService: AddressService) {

    companion object : KLogging()

    @PostMapping
    fun create(@RequestBody @Valid addressCommand: AddressCreateCommand) =
            addressService.save(addressCommand.toAddress()).also {
                logger.info("Address created successfully: {}", it)
            }.toAddressCreationResponse().toResponseEntity()
}

private fun AddressCreationResponse.toResponseEntity() =
        ResponseEntity(this,
                if (this.success) HttpStatus.CREATED else HttpStatus.CONFLICT)

private fun AddressCreationResult.toAddressCreationResponse() = AddressCreationResponse(
        id = this.address?.id,
        correctionList = this.addressValidationResult.correctionList,
        success = this.addressValidationResult.isSuccess()
)

private fun AddressCreateCommand.toAddress(): Address = Address(
        customerId = this.customerId!!,
        firstName = this.firstName!!,
        lastName = this.lastName!!,
        street = this.street!!,
        co = this.co,
        coType = this.coType,
        streetNumber = this.streetNumber!!,
        additionToAddress = this.additionToAddress,
        zip = this.zip!!,
        country = this.country!!,
        defaultBillingAddress = this.defaultBillingAddress,
        defaultShippingAddress = this.defaultShippingAddress
)
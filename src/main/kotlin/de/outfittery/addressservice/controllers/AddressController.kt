package de.outfittery.addressservice.controllers

import de.outfittery.addressservice.dtos.AddressCommand
import de.outfittery.addressservice.dtos.AddressCreationResult
import de.outfittery.addressservice.dtos.AddressValidationResult
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
    fun create(@RequestBody @Valid addressCommand: AddressCommand) =
            addressService.save(addressCommand.toAddress()).also {
                logger.info("Address create successfully: {}", it)
            }.toAddressCreationResponse().toResponseEntity()
}

private fun AddressCreationResponse.toResponseEntity() =
        ResponseEntity(this,
                if (this.addressValidationResult.isSuccess()) HttpStatus.CREATED else HttpStatus.CONFLICT)

private fun AddressCreationResult.toAddressCreationResponse() = AddressCreationResponse(
        id = this.address?.id,
        addressValidationResult = this.addressValidationResult
)

data class AddressCreationResponse(
        val id: Long?,
        val addressValidationResult: AddressValidationResult
)

private fun AddressCommand.toAddress(): Address = Address(
        text = this.text,
        customerId = this.customerId
)

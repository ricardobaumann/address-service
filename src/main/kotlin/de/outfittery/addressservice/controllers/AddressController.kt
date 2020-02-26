package de.outfittery.addressservice.controllers

import de.outfittery.addressservice.dtos.AddressCommand
import de.outfittery.addressservice.models.Address
import de.outfittery.addressservice.service.AddressService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/addresses")
class AddressController(private val addressService: AddressService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid addressCommand: AddressCommand) = addressService.save(addressCommand.toAddress())
}

private fun AddressCommand.toAddress(): Address = Address(
        id = 1L,
        text = this.text
)

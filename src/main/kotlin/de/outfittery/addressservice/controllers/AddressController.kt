package de.outfittery.addressservice.controllers

import de.outfittery.addressservice.dtos.AddressCommand
import de.outfittery.addressservice.models.Address
import de.outfittery.addressservice.service.AddressService
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.scheduling.annotation.Async
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/addresses")
class AddressController(private val addressService: AddressService) {

    companion object : KLogging()

    @Async
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid addressCommand: AddressCommand) = addressService.save(addressCommand.toAddress()).also {
        logger.info("Address create successfully: {}", it)
    }
}

private fun AddressCommand.toAddress(): Address = Address(
        id = 1L,
        text = this.text
)

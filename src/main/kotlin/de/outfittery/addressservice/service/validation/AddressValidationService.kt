package de.outfittery.addressservice.service.validation

import de.outfittery.addressservice.dtos.AddressValidationResult
import de.outfittery.addressservice.models.Address
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class AddressValidationService {

    companion object : KLogging()

    fun validate(address: Address) = AddressValidationResult()

}
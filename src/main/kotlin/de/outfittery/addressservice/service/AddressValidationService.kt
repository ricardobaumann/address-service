package de.outfittery.addressservice.service

import de.outfittery.addressservice.dtos.AddressValidationResult
import de.outfittery.addressservice.models.Address
import org.springframework.stereotype.Service

@Service
class AddressValidationService {

    fun validate(address: Address) = AddressValidationResult()

}
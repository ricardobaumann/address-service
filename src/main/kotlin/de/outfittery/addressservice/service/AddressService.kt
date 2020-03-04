package de.outfittery.addressservice.service

import de.outfittery.addressservice.dtos.AddressCreationResult
import de.outfittery.addressservice.dtos.AddressEventDto
import de.outfittery.addressservice.dtos.AddressValidationCommand
import de.outfittery.addressservice.models.Address
import de.outfittery.addressservice.repos.AddressRepo
import de.outfittery.addressservice.service.validation.AddressValidationService
import mu.KLogging
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Service
@Validated
class AddressService(private val addressRepo: AddressRepo,
                     private val addressValidationService: AddressValidationService,
                     private val applicationEventPublisher: ApplicationEventPublisher) {

    companion object : KLogging()

    @Transactional
    fun save(@Valid address: Address): AddressCreationResult =
            addressValidationService.validate(AddressValidationCommand(someAddressField = address.text))
                    .let {
                        AddressCreationResult(
                                addressValidationResult = it,
                                address = if (it.isSuccess()) saveAndPublish(address) else null
                        )
                    }

    private fun saveAndPublish(address: Address) =
            addressRepo.save(address).also {
                applicationEventPublisher.publishEvent(AddressEventDto(it))
            }
}
package de.outfittery.addressservice.service.validation

import de.outfittery.addressservice.dtos.AddressValidationCommand
import de.outfittery.addressservice.dtos.AddressValidationResult
import de.outfittery.addressservice.dtos.AddressValidationStatus
import de.outfittery.addressservice.models.AddressValidationEvent
import de.outfittery.addressservice.repos.AddressValidationEventRepo
import mu.KLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class AddressValidationService(private val applicationEventPublisher: ApplicationEventPublisher,
                               private val addressValidationEventRepo: AddressValidationEventRepo) {

    companion object : KLogging()

    @Cacheable("addresses")
    fun validate(addressValidationCommand: AddressValidationCommand) =
            validateOn3rdParty(addressValidationCommand)
                    .also {
                        applicationEventPublisher.publishEvent(it)
                    }

    private fun validateOn3rdParty(addressValidationCommand: AddressValidationCommand) =
            AddressValidationResult(
                    addressValidationCommand = addressValidationCommand,
                    status = AddressValidationStatus.VALID,
                    correctionList = listOf(AddressValidationCommand(
                            someAddressField = addressValidationCommand.someAddressField //TODO define fields to be returned
                    ))
            )

    @Async
    @EventListener
    fun on(addressValidationResult: AddressValidationResult) {
        addressValidationEventRepo.save(AddressValidationEvent(
                content = addressValidationResult
        ))
        logger.info("Address validation result persisted : {}", addressValidationResult)
    }

}
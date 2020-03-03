package de.outfittery.addressservice.events

import de.outfittery.addressservice.dtos.AddressCreationResult
import de.outfittery.addressservice.models.AddressValidationEvent
import de.outfittery.addressservice.repos.AddressValidationEventRepo
import de.outfittery.addressservice.service.AddressService
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class AddressValidationResultDbLogger(private val addressValidationEventRepo: AddressValidationEventRepo) {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun on(addressCreationResult: AddressCreationResult) {
        addressValidationEventRepo.save(AddressValidationEvent(
                address = addressCreationResult.address,
                content = addressCreationResult.addressValidationResult
        ))
        AddressService.logger.info("Address Creation result persisted : {}", addressCreationResult)
    }

}
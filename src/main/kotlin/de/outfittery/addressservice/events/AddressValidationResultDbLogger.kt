package de.outfittery.addressservice.events

import de.outfittery.addressservice.dtos.AddressValidationEventDto
import de.outfittery.addressservice.models.AddressValidationEvent
import de.outfittery.addressservice.service.validation.AddressValidationEventService
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class AddressValidationResultDbLogger(private val addressValidationEventService: AddressValidationEventService) {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun on(addressValidationEventDto: AddressValidationEventDto) {

        addressValidationEventService.save(AddressValidationEvent(
                address = addressValidationEventDto.address,
                content = addressValidationEventDto.addressValidationResult
        ))
    }

}
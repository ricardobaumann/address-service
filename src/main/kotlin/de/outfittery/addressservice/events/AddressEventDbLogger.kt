package de.outfittery.addressservice.events

import de.outfittery.addressservice.models.AddressEvent
import de.outfittery.addressservice.service.AddressEventService
import mu.KLogging
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class AddressEventDbLogger(private val addressEventService: AddressEventService) {

    companion object : KLogging()

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun on(eventDto: AddressEventDto) {
        try {
            addressEventService.save(AddressEvent(content = eventDto))
        } catch (e: Exception) {
            logger.warn("Failed to persist address event on db: {}", eventDto, e)
        }
    }
}
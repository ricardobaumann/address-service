package de.outfittery.addressservice.events

import de.outfittery.addressservice.dtos.AddressEventDto
import mu.KLogging
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class AddressEventKafkaLogger {

    companion object : KLogging()

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun on(eventDto: AddressEventDto) {
        logger.info("Logging event on kafka: {}", eventDto)
    }

}
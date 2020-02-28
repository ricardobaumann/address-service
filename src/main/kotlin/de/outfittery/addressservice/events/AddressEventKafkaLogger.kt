package de.outfittery.addressservice.events

import com.fasterxml.jackson.databind.ObjectMapper
import de.outfittery.addressservice.dtos.AddressEventDto
import mu.KLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class AddressEventKafkaLogger(private val kafkaTemplate: KafkaTemplate<String, String>,
                              private val objectMapper: ObjectMapper) {

    companion object : KLogging()

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun on(eventDto: AddressEventDto) {
        logger.info("Logging event on kafka: {}", eventDto)
        kafkaTemplate.sendDefault(objectMapper.writeValueAsString(eventDto))
    }

}
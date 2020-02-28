package de.outfittery.addressservice.events

import mu.KLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class TestKafkaListener {

    companion object : KLogging()

    @KafkaListener(topics = ["addresses"], groupId = "test")
    fun listen(message: String) {
        logger.info("Message consumed from kafka: {}", message)
    }

}
package de.outfittery.addressservice

import de.outfittery.addressservice.dtos.AddressCreationResponse
import mu.KLogging
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.net.URL
import java.time.Instant
import java.util.concurrent.Executors

@Component
class LoadTesting {
    companion object : KLogging()

    @Scheduled(fixedDelay = Long.MAX_VALUE)
    fun run() {
        val users = 1
        val requestsPerUser = 10
        val executorService = Executors.newFixedThreadPool(users)
        val restTemplate = RestTemplate()
        (1..users).forEach { users ->
            (1..requestsPerUser).forEach {
                executorService.submit {
                    val startTime = Instant.now()
                    val entity = RequestEntity.post(URL("http://localhost:8080/addresses").toURI()).contentType(MediaType.APPLICATION_JSON).body("""
            {
              "customerId": $users,
              "firstName": "Address",
              "lastName": "Service",
              "street": "Addessstrasse",
              "co": "Address man",
              "coType": "COMPANY",
              "streetNumber": "7A",
              "additionToAddress": "take care with my package",
              "zip": "12207",
              "country": "DE",
              "defaultShippingAddress": true,
              "defaultBillingAddress": true
            }
        """.trimIndent())
                    val result = restTemplate.exchange(entity, AddressCreationResponse::class.java);
                    logger.info("Body: {}", result.body)
                    logger.info("Status: {}", result.statusCode)
                    logger.info("Took {} millis", (Instant.now().minusMillis(startTime.toEpochMilli()).toEpochMilli()))
                }
            }

        }
        executorService.shutdown()
    }
}
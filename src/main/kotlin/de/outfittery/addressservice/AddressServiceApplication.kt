package de.outfittery.addressservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class AddressServiceApplication

fun main(args: Array<String>) {
    runApplication<AddressServiceApplication>(*args)
}

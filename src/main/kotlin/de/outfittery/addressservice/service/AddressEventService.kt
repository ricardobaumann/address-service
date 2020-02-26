package de.outfittery.addressservice.service

import de.outfittery.addressservice.models.AddressEvent
import de.outfittery.addressservice.repos.AddressEventRepo
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Service
@Validated
class AddressEventService(private val addressEventRepo: AddressEventRepo) {

    companion object : KLogging()

    fun save(@Valid addressEvent: AddressEvent) {
        addressEventRepo.save(addressEvent).also {
            logger.info("Event stored in db: {}", it)
        }
    }
}
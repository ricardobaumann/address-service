package de.outfittery.addressservice.service.validation

import de.outfittery.addressservice.models.AddressValidationEvent
import de.outfittery.addressservice.repos.AddressValidationEventRepo
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Service
@Validated
class AddressValidationEventService(private val addressValidationEventRepo: AddressValidationEventRepo) {

    companion object : KLogging()

    fun save(@Valid addressValidationEvent: AddressValidationEvent) {
        addressValidationEventRepo.save(addressValidationEvent)
                .also { logger.info("Address Validation event stored in db: {}", it) }
    }

}
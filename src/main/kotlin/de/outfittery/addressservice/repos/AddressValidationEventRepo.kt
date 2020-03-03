package de.outfittery.addressservice.repos

import de.outfittery.addressservice.models.AddressValidationEvent
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressValidationEventRepo : CrudRepository<AddressValidationEvent, Long>
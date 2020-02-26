package de.outfittery.addressservice.repos

import de.outfittery.addressservice.models.AddressEvent
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressEventRepo : CrudRepository<AddressEvent, String>
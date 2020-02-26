package de.outfittery.addressservice.repos

import de.outfittery.addressservice.models.Address
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepo : CrudRepository<Address, Long>
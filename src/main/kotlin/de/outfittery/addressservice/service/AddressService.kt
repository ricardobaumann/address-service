package de.outfittery.addressservice.service

import de.outfittery.addressservice.events.AddressEventPublisher
import de.outfittery.addressservice.models.Address
import de.outfittery.addressservice.repos.AddressRepo
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class AddressService(private val addressRepo: AddressRepo,
                     private val addressEventPublisher: AddressEventPublisher) {

    @Transactional
    fun save(address: Address): Address = addressRepo.save(address)
            .also { addressEventPublisher.publish(it) }
}
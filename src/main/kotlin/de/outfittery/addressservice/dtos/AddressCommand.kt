package de.outfittery.addressservice.dtos

import javax.validation.constraints.NotNull

data class AddressCommand(
        @field:NotNull val text: String? = null
)
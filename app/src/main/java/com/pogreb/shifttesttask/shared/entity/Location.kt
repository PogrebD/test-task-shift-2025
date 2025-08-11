package com.pogreb.shifttesttask.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val street: Street,
    val city: String,
    val state:String,
    val country: String,
    val coordinates: Coordinates,
    val timezone: Timezone,
)

package com.pogreb.shifttesttask.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    val latitude: String,
    val longitude: String,
)

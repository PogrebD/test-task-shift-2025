package com.pogreb.shifttesttask.userlist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    val latitude: String,
    val longitude: String,
)

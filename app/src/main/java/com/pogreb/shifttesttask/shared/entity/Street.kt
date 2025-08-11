package com.pogreb.shifttesttask.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class Street(
    val number: Long,
    val name: String,
)

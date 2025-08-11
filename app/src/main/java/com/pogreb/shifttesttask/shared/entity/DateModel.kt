package com.pogreb.shifttesttask.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class DateModel(
    val date: String,
    val age: Int,
)

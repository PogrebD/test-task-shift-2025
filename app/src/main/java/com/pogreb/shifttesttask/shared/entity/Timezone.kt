package com.pogreb.shifttesttask.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    val offset: String,
    val description: String,
)

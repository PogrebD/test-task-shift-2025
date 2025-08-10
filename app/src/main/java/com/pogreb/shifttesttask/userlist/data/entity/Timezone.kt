package com.pogreb.shifttesttask.userlist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    val offset: String,
    val description: String,
)

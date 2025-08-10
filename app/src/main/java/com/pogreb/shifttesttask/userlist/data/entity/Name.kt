package com.pogreb.shifttesttask.userlist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val title: String,
    val first: String,
    val last: String,
)

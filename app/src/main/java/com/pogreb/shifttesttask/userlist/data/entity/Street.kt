package com.pogreb.shifttesttask.userlist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Street(
    val number: Long,
    val name: String,
)

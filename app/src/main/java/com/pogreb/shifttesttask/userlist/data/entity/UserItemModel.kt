package com.pogreb.shifttesttask.userlist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class UserItemModel(
    val name: Name,
    val picture: Picture,
    val location: Location,
    val phone: String,
)

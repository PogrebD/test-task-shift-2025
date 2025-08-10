package com.pogreb.shifttesttask.userlist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Results(
    val results: List<UserItemModel>
)
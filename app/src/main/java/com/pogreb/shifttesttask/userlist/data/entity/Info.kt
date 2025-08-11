package com.pogreb.shifttesttask.userlist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val seed: String,
    val results: Long,
    val page: Long,
    val version: String,
)

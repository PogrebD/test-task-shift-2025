package com.pogreb.shifttesttask.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val uuid: String,
    val username: String,
)

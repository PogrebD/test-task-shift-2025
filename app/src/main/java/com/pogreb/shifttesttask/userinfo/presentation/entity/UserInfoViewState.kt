package com.pogreb.shifttesttask.userinfo.presentation.entity

import kotlinx.serialization.Serializable

@Serializable
data class UserInfoViewState(
    val gender: String,
    val name: String,
    val city: String,
    val state: String,
    val country: String,
    val address: String,
    val coordinates: String,
    val email: String,
    val id: String,
    val username: String,
    val dob: String,
    val registered: String,
    val phone: String,
    val picture: String,
    val nat: String,
)

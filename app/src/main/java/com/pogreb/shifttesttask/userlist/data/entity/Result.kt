package com.pogreb.shifttesttask.userlist.data.entity

import com.pogreb.shifttesttask.shared.entity.DateModel
import com.pogreb.shifttesttask.shared.entity.Location
import com.pogreb.shifttesttask.shared.entity.Login
import com.pogreb.shifttesttask.shared.entity.Name
import com.pogreb.shifttesttask.shared.entity.Picture
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: DateModel,
    val registered: DateModel,
    val phone: String,
    val picture: Picture,
    val nat: String,
)

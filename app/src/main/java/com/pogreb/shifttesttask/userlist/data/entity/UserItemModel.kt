package com.pogreb.shifttesttask.userlist.data.entity

import com.pogreb.shifttesttask.shared.entity.Location
import com.pogreb.shifttesttask.shared.entity.Name
import com.pogreb.shifttesttask.shared.entity.Picture

data class UserItemModel(
    val id: String,
    val name: Name,
    val picture: Picture,
    val location: Location,
    val phone: String,
)

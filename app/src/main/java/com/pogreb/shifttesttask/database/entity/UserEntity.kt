package com.pogreb.shifttesttask.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pogreb.shifttesttask.shared.entity.Location
import com.pogreb.shifttesttask.shared.entity.Name
import com.pogreb.shifttesttask.shared.entity.Picture
import com.pogreb.shifttesttask.shared.entity.DateModel

@Entity(tableName = "users")
data class UserEntity (
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    @PrimaryKey val id: String,
    val username: String,
    val dob: DateModel,
    val registered: DateModel,
    val phone: String,
    val picture: Picture,
    val nat: String,
)
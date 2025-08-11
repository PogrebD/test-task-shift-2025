package com.pogreb.shifttesttask.userlist.data.converter

import com.pogreb.shifttesttask.database.entity.UserEntity
import com.pogreb.shifttesttask.userlist.data.entity.Result

class UserEntityConverter {
    fun convert(model: Result): UserEntity =
        UserEntity(
            gender = model.gender,
            name = model.name,
            location = model.location,
            email = model.email,
            id = model.login.uuid,
            username = model.login.username,
            dob = model.dob,
            registered = model.registered,
            phone = model.phone,
            picture = model.picture,
            nat = model.nat,
        )
}
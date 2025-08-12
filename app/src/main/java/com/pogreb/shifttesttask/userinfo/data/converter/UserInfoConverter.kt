package com.pogreb.shifttesttask.userinfo.data.converter

import com.pogreb.shifttesttask.database.entity.UserEntity
import com.pogreb.shifttesttask.userinfo.domain.UserInfo

class UserInfoConverter {
    fun convert(model: UserEntity): UserInfo =
        UserInfo(
            gender = model.gender,
            name = model.name,
            location = model.location,
            email = model.email,
            id = model.id,
            username = model.username,
            dob = model.dob,
            registered = model.registered,
            phone = model.phone,
            picture = model.picture,
            nat = model.nat,
        )
}
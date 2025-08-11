package com.pogreb.shifttesttask.userlist.data.converter

import com.pogreb.shifttesttask.database.entity.UserEntity
import com.pogreb.shifttesttask.userlist.domain.entity.UserItem

class UserItemConverter {
    fun convert(model: UserEntity): UserItem =
        UserItem(
            name = model.name,
            picture = model.picture.large,
            phone = model.phone,
            address = model.location.street,
        )
}

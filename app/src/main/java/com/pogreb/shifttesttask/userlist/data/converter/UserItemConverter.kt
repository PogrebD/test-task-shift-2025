package com.pogreb.shifttesttask.userlist.data.converter

import com.pogreb.shifttesttask.userlist.data.entity.UserItemModel
import com.pogreb.shifttesttask.userlist.domain.entity.UserItem

class UserItemConverter {
    fun convert(model: UserItemModel): UserItem =
        UserItem(
            id = model.id,
            name = model.name,
            picture = model.picture.large,
            phone = model.phone,
            address = model.location.street,
        )
}

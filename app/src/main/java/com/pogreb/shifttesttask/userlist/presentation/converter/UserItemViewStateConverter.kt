package com.pogreb.shifttesttask.userlist.presentation.converter

import android.content.Context
import com.pogreb.shifttesttask.R
import com.pogreb.shifttesttask.shared.entity.Name
import com.pogreb.shifttesttask.shared.entity.Street
import com.pogreb.shifttesttask.userlist.domain.entity.UserItem
import com.pogreb.shifttesttask.userlist.presentation.entity.UserItemViewState

class UserItemViewStateConverter(private val context: Context) {
    fun convert(item: UserItem): UserItemViewState =
        UserItemViewState(
            id = item.id,
            name = formatName(item.name, context),
            picture = item.picture,
            address = formatAddress(item.address, context),
            phone = item.phone
        )
}

private fun formatName(name: Name, context: Context): String {
    return context.getString(
        R.string.full_name_template,
        name.title,
        name.first,
        name.last,
    )
}

private fun formatAddress(address: Street, context: Context): String {
    return context.getString(
        R.string.address_template,
        address.number,
        address.name,
    )
}
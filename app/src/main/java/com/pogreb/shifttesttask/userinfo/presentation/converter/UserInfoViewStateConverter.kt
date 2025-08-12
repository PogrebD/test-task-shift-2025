package com.pogreb.shifttesttask.userinfo.presentation.converter

import android.content.Context
import com.pogreb.shifttesttask.R
import com.pogreb.shifttesttask.shared.entity.Coordinates
import com.pogreb.shifttesttask.shared.entity.DateModel
import com.pogreb.shifttesttask.shared.entity.Name
import com.pogreb.shifttesttask.shared.entity.Street
import com.pogreb.shifttesttask.userinfo.domain.UserInfo
import com.pogreb.shifttesttask.userinfo.presentation.entity.UserInfoViewState
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class UserInfoViewStateConverter(private val context: Context) {
    fun convert(model: UserInfo): UserInfoViewState =
        UserInfoViewState(
            gender = model.gender,
            name = formatName(model.name, context),
            email = model.email,
            id = model.id,
            username = model.username,
            dob = formatDate(model.dob, context),
            registered = formatDate(model.registered, context),
            phone = model.phone,
            picture = model.picture.large,
            nat = model.nat,
            city = model.location.city,
            state = model.location.state,
            country = model.location.country,
            address = formatAddress(model.location.street, context),
            coordinates = formatCoordinates(model.location.coordinates, context),
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

private fun formatCoordinates(coordinates: Coordinates, context: Context): String {
    return context.getString(
        R.string.coordinates_template,
        coordinates.latitude,
        coordinates.longitude,
    )
}

private fun formatDate(dateModel: DateModel, context: Context): String {
    val formatter = DateTimeFormatter.ofPattern(context.getString(R.string.date_format))
    val zonedDateModel = Instant.parse(dateModel.date).atZone(ZoneId.systemDefault())
    return formatter.format(zonedDateModel)
}
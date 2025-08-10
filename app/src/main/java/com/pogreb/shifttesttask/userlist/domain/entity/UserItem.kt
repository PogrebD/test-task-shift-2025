package com.pogreb.shifttesttask.userlist.domain.entity

import com.pogreb.shifttesttask.userlist.data.entity.Name
import com.pogreb.shifttesttask.userlist.data.entity.Street

data class UserItem(
    val name: Name,
    val picture: String,
    val address: Street,
    val phone: String,
)

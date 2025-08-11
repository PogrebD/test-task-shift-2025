package com.pogreb.shifttesttask.userlist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val results: List<Result>,
    val info: Info,
)

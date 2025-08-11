package com.pogreb.shifttesttask.userlist.data

import com.pogreb.shifttesttask.userlist.data.entity.ApiResponse
import retrofit2.http.GET

interface UserListApi {
    @GET("?results=10")
    suspend fun getUsers(): ApiResponse
}
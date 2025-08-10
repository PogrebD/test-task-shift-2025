package com.pogreb.shifttesttask.userlist.data

import com.pogreb.shifttesttask.userlist.data.entity.Results
import retrofit2.http.GET

interface UserListApi {
    @GET("?inc=name, picture, location, phone&results=10&noinfo")
    suspend fun getUsers(): Results
}
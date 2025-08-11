package com.pogreb.shifttesttask.userlist.data.repository

import com.pogreb.shifttesttask.userlist.data.UserListApi
import com.pogreb.shifttesttask.userlist.data.converter.UserItemConverter
import com.pogreb.shifttesttask.userlist.data.entity.Result
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: UserListApi,
    private val converter: UserItemConverter,
) {
    suspend fun getNumUsers(): List<Result> =
        api.getUsers().results
}
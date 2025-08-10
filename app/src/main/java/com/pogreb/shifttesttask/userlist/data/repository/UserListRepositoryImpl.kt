package com.pogreb.shifttesttask.userlist.data.repository

import com.pogreb.shifttesttask.userlist.data.UserListApi
import com.pogreb.shifttesttask.userlist.data.converter.UserItemConverter
import com.pogreb.shifttesttask.userlist.domain.entity.UserItem
import com.pogreb.shifttesttask.userlist.domain.repository.UserListRepository
import javax.inject.Inject

class UserListRepositoryImpl @Inject constructor(
    private val api: UserListApi,
    private val converter: UserItemConverter,
) : UserListRepository {
    override suspend fun getUsers(): List<UserItem> =
        api.getUsers().results.map { converter.convert(it) }
}
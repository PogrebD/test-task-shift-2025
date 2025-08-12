package com.pogreb.shifttesttask.userlist.domain.repository

import com.pogreb.shifttesttask.userlist.domain.entity.UserItem

interface UserListRepository {
    suspend fun getUsers(): List<UserItem>

    suspend fun refreshUsers(): List<UserItem>
}
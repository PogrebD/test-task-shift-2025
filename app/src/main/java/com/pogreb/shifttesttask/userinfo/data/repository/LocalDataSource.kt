package com.pogreb.shifttesttask.userinfo.data.repository

import com.pogreb.shifttesttask.database.UserDao
import com.pogreb.shifttesttask.database.entity.UserEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: UserDao,
) {
    fun getUserInfo(id: String): UserEntity {
        return dao.getUserById(id)
    }
}
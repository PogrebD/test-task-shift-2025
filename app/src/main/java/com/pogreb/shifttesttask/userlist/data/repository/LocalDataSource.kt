package com.pogreb.shifttesttask.userlist.data.repository

import com.pogreb.shifttesttask.database.UserDao
import com.pogreb.shifttesttask.database.entity.UserEntity
import com.pogreb.shifttesttask.userlist.data.converter.UserEntityConverter
import com.pogreb.shifttesttask.userlist.data.entity.Result
import javax.inject.Inject
import kotlin.collections.map

class LocalDataSource @Inject constructor(
    private val dao: UserDao,
    private val converter: UserEntityConverter,
) {
    fun getData(): List<UserEntity> {
        return dao.getAllUsers()
    }

    suspend fun saveData(data: List<Result>) {
        val entities = data.map { converter.convert(it) }
        dao.insert(entities)
    }
}
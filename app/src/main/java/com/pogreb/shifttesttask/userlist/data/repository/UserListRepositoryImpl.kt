package com.pogreb.shifttesttask.userlist.data.repository

import com.pogreb.shifttesttask.userlist.data.UserListApi
import com.pogreb.shifttesttask.userlist.data.converter.UserItemConverter
import com.pogreb.shifttesttask.userlist.domain.entity.UserItem
import com.pogreb.shifttesttask.userlist.domain.repository.UserListRepository
import javax.inject.Inject

class UserListRepositoryImpl @Inject constructor(
    private val converter: UserItemConverter,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : UserListRepository {
    override suspend fun getUsers(): List<UserItem> {
        val cached = localDataSource.getData().firstOrNull()
        if (cached == null) {
            val remoteData = remoteDataSource.getNumUsers()
            localDataSource.saveData(remoteData)
        }

        return localDataSource.getData().map { converter.convert(it) }
    }


}
package com.pogreb.shifttesttask.userinfo.data.repository

import com.pogreb.shifttesttask.userinfo.data.converter.UserInfoConverter
import com.pogreb.shifttesttask.userinfo.domain.UserInfo
import com.pogreb.shifttesttask.userinfo.domain.repository.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val converter: UserInfoConverter,
    private val localDataSource: LocalDataSource,
) : UserInfoRepository {
    override suspend fun getUserInfo(id: String): UserInfo {
        return localDataSource.getUserInfo(id).let { converter.convert( it ) }
    }
}
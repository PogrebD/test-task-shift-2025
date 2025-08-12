package com.pogreb.shifttesttask.userinfo.domain.repository

import com.pogreb.shifttesttask.userinfo.domain.UserInfo

interface UserInfoRepository {
    suspend fun getUserInfo(id: String): UserInfo
}
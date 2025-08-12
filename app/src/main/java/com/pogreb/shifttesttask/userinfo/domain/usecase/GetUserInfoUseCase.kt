package com.pogreb.shifttesttask.userinfo.domain.usecase

import com.pogreb.shifttesttask.userinfo.domain.UserInfo
import com.pogreb.shifttesttask.userinfo.domain.repository.UserInfoRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val userInfoRepository: UserInfoRepository) {
    suspend fun invoke(id: String): UserInfo =
        userInfoRepository.getUserInfo(id)
}
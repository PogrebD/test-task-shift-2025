package com.pogreb.shifttesttask.userinfo.presentation

import com.pogreb.shifttesttask.userinfo.presentation.entity.UserInfoViewState

interface UserInfoState {
    data class Idle(val userInfo: UserInfoViewState) : UserInfoState
    data object Loading : UserInfoState
    data class Error(val reason: String) : UserInfoState
}
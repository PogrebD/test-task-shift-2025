package com.pogreb.shifttesttask.userlist.presentation

import com.pogreb.shifttesttask.userlist.presentation.entity.UserItemViewState

interface UserListState {
    data class Idle(val users: List<UserItemViewState>) : UserListState
    data object Loading : UserListState
    data class Error(val reason: String) : UserListState
}
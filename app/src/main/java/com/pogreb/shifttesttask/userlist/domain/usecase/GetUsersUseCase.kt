package com.pogreb.shifttesttask.userlist.domain.usecase

import com.pogreb.shifttesttask.userlist.domain.entity.UserItem
import com.pogreb.shifttesttask.userlist.domain.repository.UserListRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userListRepository: UserListRepository) {
    suspend fun invoke(): List<UserItem> =
        userListRepository.getUsers()
}
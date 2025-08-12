package com.pogreb.shifttesttask.userlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.shifttesttask.userlist.domain.usecase.GetUsersUseCase
import com.pogreb.shifttesttask.userlist.presentation.converter.UserItemViewStateConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val converter: UserItemViewStateConverter,
) : ViewModel() {
    private val _state = MutableStateFlow<UserListState>(UserListState.Loading)
    val state: StateFlow<UserListState> = _state.asStateFlow()

    fun loadData() {
        _state.value = UserListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userList = getUsersUseCase.invoke()
                _state.value = UserListState.Idle(
                    users = userList.map { item -> converter.convert(item) })
            } catch (e: Exception) {
                _state.value = UserListState.Error(e.message.orEmpty())
            }
        }
    }
}
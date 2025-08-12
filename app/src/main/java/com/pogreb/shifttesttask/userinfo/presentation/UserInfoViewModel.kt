package com.pogreb.shifttesttask.userinfo.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.shifttesttask.userinfo.domain.usecase.GetUserInfoUseCase
import com.pogreb.shifttesttask.userinfo.presentation.converter.UserInfoViewStateConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val converter: UserInfoViewStateConverter,
) : ViewModel() {
    private val userId: String = checkNotNull(savedStateHandle["userId"])

    private val _state = MutableStateFlow<UserInfoState>(UserInfoState.Loading)
    val state: StateFlow<UserInfoState> = _state.asStateFlow()

    fun loadUserInfo() {
        _state.value = UserInfoState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = getUserInfoUseCase.invoke(userId)
                _state.value = UserInfoState.Idle(
                    userInfo = user.let { it -> converter.convert(it) })
            } catch (e: Exception) {
                _state.value = UserInfoState.Error(e.message.orEmpty())
            }
        }
    }
}
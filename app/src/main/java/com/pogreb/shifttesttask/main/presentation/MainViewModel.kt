package com.pogreb.shifttesttask.main.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _topBarState = MutableStateFlow<TopBarState>(TopBarState.UserList)
    val topBarState: StateFlow<TopBarState> get() = _topBarState.asStateFlow()

    fun updateTopBar(newState: TopBarState) {
        _topBarState.value = newState
    }
}
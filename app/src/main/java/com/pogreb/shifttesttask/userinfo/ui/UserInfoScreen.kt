package com.pogreb.shifttesttask.userinfo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.pogreb.shifttesttask.shared.ui.ErrorMassage
import com.pogreb.shifttesttask.shared.ui.FullScreenProgressIndicator
import com.pogreb.shifttesttask.userinfo.presentation.UserInfoState
import com.pogreb.shifttesttask.userinfo.presentation.UserInfoViewModel

@Composable
fun UserInfoScreen(
    userInfoViewModel: UserInfoViewModel,
) {
    val state by userInfoViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        userInfoViewModel.loadUserInfo()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (val currentState = state) {
            UserInfoState.Loading -> FullScreenProgressIndicator()

            is UserInfoState.Idle ->
                UserInfoContent(currentState.userInfo)

            is UserInfoState.Error -> ErrorMassage(
                message = currentState.reason,
                onRetry = userInfoViewModel::loadUserInfo
            )
        }
    }
}
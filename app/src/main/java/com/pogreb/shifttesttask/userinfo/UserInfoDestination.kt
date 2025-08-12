package com.pogreb.shifttesttask.userinfo

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pogreb.shifttesttask.main.presentation.MainViewModel
import com.pogreb.shifttesttask.main.presentation.TopBarState
import com.pogreb.shifttesttask.userinfo.presentation.UserInfoViewModel
import com.pogreb.shifttesttask.userinfo.ui.UserInfoScreen


fun NavGraphBuilder.userInfo(mainViewModel: MainViewModel) {
    composable<UserInfoRoute> {
        val userInfoViewModel: UserInfoViewModel = hiltViewModel()
        mainViewModel.updateTopBar(TopBarState.UserInfo)
        UserInfoScreen(
            userInfoViewModel = userInfoViewModel,
        )
    }
}
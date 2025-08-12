package com.pogreb.shifttesttask.userlist

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pogreb.shifttesttask.main.presentation.MainViewModel
import com.pogreb.shifttesttask.main.presentation.TopBarState
import com.pogreb.shifttesttask.userinfo.UserInfoRoute
import com.pogreb.shifttesttask.userlist.presentation.UserListViewModel
import com.pogreb.shifttesttask.userlist.ui.UserListScreen

fun NavGraphBuilder.userList(navController: NavHostController, mainViewModel: MainViewModel) {
    composable<UserListRoute> {
        val userListViewModel: UserListViewModel = hiltViewModel()
        mainViewModel.updateTopBar(TopBarState.UserList)
        UserListScreen(
            userListViewModel,
            onItemClick = { userId ->
                navController.navigate(
                    UserInfoRoute(userId)
                )
            }
        )
    }
}
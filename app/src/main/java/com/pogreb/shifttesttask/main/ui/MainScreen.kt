package com.pogreb.shifttesttask.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.pogreb.shifttesttask.R
import com.pogreb.shifttesttask.main.presentation.MainViewModel
import com.pogreb.shifttesttask.main.presentation.TopBarState
import com.pogreb.shifttesttask.userinfo.userInfo
import com.pogreb.shifttesttask.userlist.UserListRoute
import com.pogreb.shifttesttask.userlist.userList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val mainViewModel: MainViewModel = hiltViewModel()

    val state by mainViewModel.topBarState.collectAsState()

    Scaffold(
        topBar = {
            when (state) {
                is TopBarState.UserList -> UserListTopBar()
                is TopBarState.UserInfo -> UserInfoTopBar(navController)
            }
        },
        content =
            { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = UserListRoute,
                    ) {
                        userList(navController, mainViewModel)
                        userInfo(mainViewModel)
                    }
                }
            },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoTopBar(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(stringResource(R.string.user_info_title))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        navigationIcon = {
            IconButton(
                navController::popBackStack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListTopBar() {
    TopAppBar(
        title = {
            Text(stringResource(R.string.user_list_title))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        )
    )
}
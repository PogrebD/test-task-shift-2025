package com.pogreb.shifttesttask.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pogreb.shifttesttask.userlist.presentation.UserListViewModel
import com.pogreb.shifttesttask.userlist.ui.UserListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val userListViewModel: UserListViewModel = hiltViewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Список пользователей") }
            )
        },
        content =
            { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    UserListScreen(
                        userListViewModel,
                        onItemClick = { }
                    )
                }
            },
    )
}
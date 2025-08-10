package com.pogreb.shifttesttask.userlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.pogreb.shifttesttask.shared.ui.ErrorMassage
import com.pogreb.shifttesttask.shared.ui.FullScreenProgressIndicator
import com.pogreb.shifttesttask.userlist.presentation.UserListState
import com.pogreb.shifttesttask.userlist.presentation.UserListViewModel

@Composable
fun UserListScreen(
    userListViewModel: UserListViewModel,
    onItemClick: (Long) -> Unit,
) {
    val state by userListViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        userListViewModel.loadData()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (val currentState = state) {
            UserListState.Loading -> FullScreenProgressIndicator()

            is UserListState.Idle ->
                UserListContent(currentState, onItemClick, userListViewModel.baseUrl)

            is UserListState.Error -> ErrorMassage(
                message = currentState.reason,
                onRetry = userListViewModel::loadData
            )
        }
    }
}
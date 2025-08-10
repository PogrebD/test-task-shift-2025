package com.pogreb.shifttesttask.userlist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pogreb.shifttesttask.R
import com.pogreb.shifttesttask.shared.di.BaseUrl
import com.pogreb.shifttesttask.userlist.presentation.UserListState
import com.pogreb.shifttesttask.userlist.presentation.entity.UserItemViewState

@Composable
fun UserListContent(
    state: UserListState.Idle,
    onItemClick: (Long) -> Unit,
    @BaseUrl baseUrl: String,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()

    ) {
        items(state.users) { item ->

            UserListItem(
                item = item,
                onItemClick = onItemClick,
                baseUrl = baseUrl,
            )

        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserListItem(
    item: UserItemViewState,
    onItemClick: (Long) -> Unit,
    @BaseUrl baseUrl: String,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(vertical = 1.dp)
        //.clickable { onItemClick(item.id) },

    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ) {
                GlideImage(
                    model = item.picture,
                    contentDescription = "User image",
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                ) {
                    it
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.error_image)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = item.name,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Row {
                        Image(
                            painter = painterResource(R.drawable.baseline_home_24),
                            contentDescription = null,
                        )
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = item.address,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }


                    Row {
                        Image(
                            painter = painterResource(R.drawable.baseline_phone_24),
                            contentDescription = null,
                        )
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = item.phone,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }
    }
}

/*
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun UserListItemPreview() {
    MaterialTheme {
        UserListItem(
            item = UserItemViewState(
                name = "Miss Jennie Nichols",
                address = "8929 Valwood Pkwy",
                phone = "(272) 790-0888",
                picture = "https://randomuser.me/api/portraits/med/men/1.jpg"
            ),
            onItemClick = {},
            baseUrl = ""
        )
    }
}*/

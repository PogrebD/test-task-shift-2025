package com.pogreb.shifttesttask.userlist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.pogreb.shifttesttask.userlist.presentation.UserListState
import com.pogreb.shifttesttask.userlist.presentation.entity.UserItemViewState

@Composable
fun UserListContent(
    state: UserListState.Idle,
    onItemClick: (String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()

    ) {
        items(state.users) { item ->

            UserListItem(
                item = item,
                onItemClick = onItemClick,
            )

        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserListItem(
    item: UserItemViewState,
    onItemClick: (String) -> Unit,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(vertical = 1.dp)
            .clickable { onItemClick(item.id) },

        ) {
        Row(
            modifier = Modifier
                .padding(all =  8.dp)
        ) {
            UserPic(item.picture)

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

                AddressText(item.address)

                PhoneText(item.phone)
            }
        }
    }
}

@Composable
fun PhoneText(phone: String) {
    Row {
        Image(
            painter = painterResource(R.drawable.baseline_phone_24),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = phone,
            fontSize = 14.sp,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
fun AddressText(address: String) {
    Row {
        Image(
            painter = painterResource(R.drawable.baseline_home_24),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = address,
            fontSize = 14.sp,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserPic(picture: String) {
    GlideImage(
        model = picture,
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
}
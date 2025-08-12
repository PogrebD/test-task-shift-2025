package com.pogreb.shifttesttask.userinfo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pogreb.shifttesttask.R
import com.pogreb.shifttesttask.userinfo.presentation.entity.UserInfoViewState

@Composable
fun UserInfoContent(
    userInfo: UserInfoViewState,
) {

    val fields = listOf(
        R.string.label_full_name to userInfo.name,
        R.string.label_username to userInfo.username,
        R.string.label_gender to userInfo.gender,
        R.string.label_nationality to userInfo.nat,
        R.string.label_dob to userInfo.dob,
        R.string.label_address to userInfo.address,
        R.string.label_city to userInfo.city,
        R.string.label_state to userInfo.state,
        R.string.label_country to userInfo.country,
        R.string.label_coordinates to userInfo.coordinates,
        R.string.label_email to userInfo.email,
        R.string.label_phone to userInfo.phone,
        R.string.label_registered to userInfo.registered,
    )

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {

        UserPic(userInfo.picture)

        fields.forEach { (label, value) ->
            LabeledText(stringResource(label), value)
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 1.dp,
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserPic(picture: String) {
    GlideImage(
        model = picture,
        contentDescription = "User image",
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
        it
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
    }
}


@Composable
fun LabeledText(label: String, text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}
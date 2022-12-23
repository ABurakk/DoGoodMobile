package com.example.dogoodmobile.android.core.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.dogoodmobile.android.R
import com.example.dogoodmobile.android.core.theme.lightColors

@Composable
fun BackArrowIcon(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = "",
        )
    }
}


@Composable
fun SettingsIcon(onClick: () -> Unit) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_settings),
            contentDescription = "",
            tint = lightColors.onBackground
        )
    }
}
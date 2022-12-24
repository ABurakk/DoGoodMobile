package com.example.dogoodmobile.android.core.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.dogoodmobile.android.core.theme.lightColors

@Composable
fun DoGoodAppTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = { Spacer(modifier = Modifier.width(64.dp)) },
    backgroundColor: Color = lightColors.secondary,
    contentColor: Color = lightColors.onBackground,
    elevation: Dp = 0.dp,
    height: Dp = 48.dp
) {
    TopAppBar(
        backgroundColor = backgroundColor,
        modifier = modifier.height(height),
        contentColor = contentColor,
        elevation = elevation,
        title = title,
        navigationIcon = navigationIcon,
        actions = actions
    )
}
package com.example.dogoodmobile.android.main_screen.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dogoodmobile.android.core.composables.DoGoodAppTopAppBar
import com.example.dogoodmobile.android.core.composables.ProfileIcon
import com.example.dogoodmobile.android.core.composables.SettingsIcon
import com.example.dogoodmobile.android.core.theme.lightColors
import com.example.dogoodmobile.volunteering.main.presentation.MainScreenEvent
import com.example.dogoodmobile.volunteering.main.presentation.MainScreenState


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    state: MainScreenState,
    onEvent: (MainScreenEvent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state) {
        val message = state.errorText
        message?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            onEvent(MainScreenEvent.ErrorSeen)
        }
    }
    Scaffold(
        topBar = {
            DoGoodAppTopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Home",
                            fontWeight = FontWeight.Bold,
                            color = lightColors.onBackground
                        )
                    }
                },
                navigationIcon = {
                    ProfileIcon {

                    }
                },
                actions = {
                    SettingsIcon {

                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item {
                ProfileHeadline(
                    onStartClick = {

                    }
                )
            }
        }
    }
}

@Composable
fun ProfileHeadline(onStartClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(size = 12.dp))
            .fillMaxWidth()
            .height(96.dp)
            .background(lightColors.primary)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Set Up \nYour Profile",
                fontWeight = FontWeight.Bold,
                color = lightColors.background
            )

            Button(
                onClick = onStartClick,
                colors = ButtonDefaults.buttonColors(backgroundColor = lightColors.background),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Text(
                    text = "Start Now",
                    fontWeight = FontWeight.Bold,
                    color = lightColors.onBackground,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                )
            }
        }
    }
}
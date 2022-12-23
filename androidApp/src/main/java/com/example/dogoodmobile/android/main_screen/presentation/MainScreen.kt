package com.example.dogoodmobile.android.main_screen.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.dogoodmobile.volunteering.main.presentation.MainScreenEvent
import com.example.dogoodmobile.volunteering.main.presentation.MainScreenState


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
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Main Screen")
    }
}
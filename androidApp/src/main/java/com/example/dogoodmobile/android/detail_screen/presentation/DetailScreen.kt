package com.example.dogoodmobile.android.detail_screen.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.example.dogoodmobile.android.core.composables.BackArrowIcon
import com.example.dogoodmobile.android.core.composables.DoGoodAppTopAppBar
import com.example.dogoodmobile.android.core.theme.lightColors
import com.example.dogoodmobile.volunteering.detail.presentation.DetailScreenEvent
import com.example.dogoodmobile.volunteering.detail.presentation.DetailScreenState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    state: DetailScreenState,
    volunteeringDetailId: String,
    onEvent: (DetailScreenEvent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state) {
        onEvent(DetailScreenEvent.LoadVolunteeringDetail(id = volunteeringDetailId))
        val message = state.errorText
        message?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            onEvent(DetailScreenEvent.ErrorSeen)
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
                            text = "Detail",
                            fontWeight = FontWeight.Bold,
                            color = lightColors.onBackground
                        )
                    }
                },
                navigationIcon = {
                    BackArrowIcon {
                        onEvent(DetailScreenEvent.ClickBackButton)
                    }
                }
            )
        }
    ) {

    }
}
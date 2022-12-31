package com.example.dogoodmobile.android.detail_screen.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogoodmobile.android.core.composables.BackArrowIcon
import com.example.dogoodmobile.android.core.composables.DoGoodAppTopAppBar
import com.example.dogoodmobile.android.core.composables.Tag
import com.example.dogoodmobile.android.core.presentation.UiVolunteering
import com.example.dogoodmobile.android.core.theme.LightBlue2
import com.example.dogoodmobile.android.core.theme.lightColors
import com.example.dogoodmobile.android.main_screen.presentation.composables.VolunteeringButton
import com.example.dogoodmobile.volunteering.detail.presentation.DetailScreenEvent
import com.example.dogoodmobile.volunteering.detail.presentation.DetailScreenState
import com.google.accompanist.flowlayout.FlowRow

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
        state.volunteering?.let {
            DetailScreenContent(uiVolunteering = UiVolunteering(it))
        }
    }
}

@Composable
fun DetailScreenContent(uiVolunteering: UiVolunteering) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp, start = 24.dp, end = 24.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = uiVolunteering.drawableRes!!),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 12.dp, start = 6.dp, end = 6.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        item {
            Text(
                text = uiVolunteering.volunteering!!.title,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(modifier = Modifier.fillMaxWidth())
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                VolunteeringButton(
                    color = LightBlue2,
                    name = "",
                    imageVector = Icons.Default.LocationCity,
                    onClick = { },
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .height(54.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = uiVolunteering.volunteering!!.ownerName,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp
                    )

                    Text(
                        text = uiVolunteering.volunteering.location.city + ", " + uiVolunteering.volunteering.location.country,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                    )
                }
            }

            Divider(modifier = Modifier.fillMaxWidth())
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                Text(
                    text = "Volunteering Detail",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                )

                Text(
                    text = uiVolunteering.volunteering!!.detail,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
            Divider(modifier = Modifier.fillMaxWidth())
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))

            Column {
                Spacer(modifier = Modifier.height(8.dp))

                FlowRow {
                    for (tag in uiVolunteering.volunteering!!.tags) {
                        Tag(text = tag)
                    }
                }
            }
        }
        item {
            Column {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = lightColors.primary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(start = 4.dp, end = 4.dp, top = 16.dp),
                    shape = RoundedCornerShape(size = 12.dp)
                ) {
                    Text(
                        text = "Contact Now",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
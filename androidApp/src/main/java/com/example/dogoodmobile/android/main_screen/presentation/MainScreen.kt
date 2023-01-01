package com.example.dogoodmobile.android.main_screen.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogoodmobile.android.core.composables.DoGoodAppTopAppBar
import com.example.dogoodmobile.android.core.composables.ProfileIcon
import com.example.dogoodmobile.android.core.composables.SettingsIcon
import com.example.dogoodmobile.android.core.presentation.UiVolunteering
import com.example.dogoodmobile.android.core.theme.*
import com.example.dogoodmobile.android.main_screen.presentation.composables.FeaturedAdInfoButton
import com.example.dogoodmobile.android.main_screen.presentation.composables.VolunteeringButton
import com.example.dogoodmobile.core.domain.VolunteeringType
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
            item {
                VolunteeringTypeIcons(
                    onVolunteeringTypeClicked = {
                        onEvent(MainScreenEvent.ChooseVolunteeringType(it))
                    }
                )
            }

            item {
                FeaturedAd(
                    UiVolunteering(state.randomVolunteeringAd),
                    isLoading = state.isLoading,
                    onRefreshClick = {
                        onEvent(MainScreenEvent.ClickRefreshFeaturedAd)
                    },
                    onVolunteeringDetailClicked = {
                        onEvent(MainScreenEvent.ClickFeaturedVolunteeringAd(it))
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
            .padding(start = 16.dp, end = 16.dp, top = 18.dp, bottom = 16.dp)
            .clip(shape = RoundedCornerShape(size = 12.dp))
            .fillMaxWidth()
            .height(96.dp)
            .background(lightColors.primary)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Start New \nVolunteering Project",
                fontWeight = FontWeight.Bold,
                color = lightColors.background,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 24.dp)
            )

            Button(
                onClick = onStartClick,
                colors = ButtonDefaults.buttonColors(backgroundColor = lightColors.background),
                shape = RoundedCornerShape(size = 12.dp),
                modifier = Modifier
                    .height(42.dp)
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = "Start Now",
                    fontWeight = FontWeight.Bold,
                    color = lightColors.onBackground,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun VolunteeringTypeIcons(
    onVolunteeringTypeClicked: (String) -> Unit
) {
    var expandedState by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
    ) {
        VolunteeringTypeRow1(
            volunteeringTypeExpandState = expandedState,
            expandedStateChanged = { expandedState = it },
            onVolunteeringTypeClicked = {
                onVolunteeringTypeClicked(it)
            }
        )

        if (expandedState) {
            VolunteeringTypeRow2(
                expandedStateChanged = {
                    expandedState = it
                },
                onVolunteeringTypeClicked = {
                    onVolunteeringTypeClicked(it)
                }
            )
        }
    }


}

@Composable
fun VolunteeringTypeRow1(
    volunteeringTypeExpandState: Boolean,
    expandedStateChanged: (Boolean) -> Unit,
    onVolunteeringTypeClicked: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 6.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        VolunteeringButton(
            color = Orange,
            imageVector = Icons.Default.MedicalServices,
            name = VolunteeringType.MEDICAL.title
        ) {
            onVolunteeringTypeClicked(VolunteeringType.MEDICAL.id)
        }

        VolunteeringButton(
            color = LightBlue2,
            imageVector = Icons.Default.Book,
            name = VolunteeringType.EDUCATION.title

        ) {
            onVolunteeringTypeClicked(VolunteeringType.EDUCATION.id)
        }

        VolunteeringButton(
            color = Pink,
            imageVector = Icons.Default.MiscellaneousServices,
            name = VolunteeringType.SOCIAL_SERVICES.title
        ) {
            onVolunteeringTypeClicked(VolunteeringType.SOCIAL_SERVICES.id)
        }

        if (volunteeringTypeExpandState) {
            VolunteeringButton(
                color = Green,
                imageVector = Icons.Default.Elderly,
                name = VolunteeringType.ELDER_CARE.title,
                onClick = {
                    if (volunteeringTypeExpandState) {
                        onVolunteeringTypeClicked(VolunteeringType.ELDER_CARE.id)
                        return@VolunteeringButton
                    }
                    expandedStateChanged(!volunteeringTypeExpandState)
                }
            )

        } else {
            VolunteeringButton(
                color = Green,
                imageVector = Icons.Default.SelectAll,
                name = "Other",
                onClick = {
                    expandedStateChanged(!volunteeringTypeExpandState)
                }
            )
        }
    }
}

@Composable
fun VolunteeringTypeRow2(
    expandedStateChanged: (Boolean) -> Unit,
    onVolunteeringTypeClicked: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        VolunteeringButton(
            color = Green,
            imageVector = Icons.Default.Pets,
            name = VolunteeringType.ANIMAL_RESCUE.title
        ) {
            onVolunteeringTypeClicked(VolunteeringType.ANIMAL_RESCUE.id)
        }

        VolunteeringButton(
            color = Purple,
            imageVector = Icons.Default.NightShelter,
            name = VolunteeringType.HOMELESSNESS.title
        ) {
            onVolunteeringTypeClicked(VolunteeringType.HOMELESSNESS.id)
        }

        VolunteeringButton(
            color = Red,
            imageVector = Icons.Default.Hail,
            name = VolunteeringType.IMMIGRATION.title
        ) {
            onVolunteeringTypeClicked(VolunteeringType.IMMIGRATION.id)
        }

        VolunteeringButton(
            color = Color.Black,
            imageVector = Icons.Default.ExpandLess,
            name = "Less"
        ) {
            expandedStateChanged(false)
        }

    }
}


@Composable
fun FeaturedAd(
    uiVolunteering: UiVolunteering,
    isLoading: Boolean,
    onRefreshClick: () -> Unit,
    onVolunteeringDetailClicked: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Featured",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
            )

            IconButton(onClick = { onRefreshClick() }) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "",
                )
            }
        }


        uiVolunteering.drawableRes?.let {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    alignment = Alignment.Center,
                    painter = painterResource(id = it),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                FeaturedAdInfoButton(
                    volunteering = uiVolunteering.volunteering,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp),
                    onDetailClicked = {
                        onVolunteeringDetailClicked(it)
                    }
                )
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = lightColors.onBackground,
                    )
                }
            }
        }

    }
}
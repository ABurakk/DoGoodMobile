package com.example.dogoodmobile.android.list_screen.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dogoodmobile.android.core.composables.BackArrowIcon
import com.example.dogoodmobile.android.core.composables.DoGoodAppTopAppBar
import com.example.dogoodmobile.android.core.composables.Tag
import com.example.dogoodmobile.android.core.theme.lightColors
import com.example.dogoodmobile.android.list_screen.presentation.composable.VolunteeringListItem
import com.example.dogoodmobile.core.domain.VolunteeringType
import com.example.dogoodmobile.volunteering.list.presentation.ListScreenEvent
import com.example.dogoodmobile.volunteering.list.presentation.ListScreenState


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VolunteeringListScreen(
    state: ListScreenState,
    typeId: String,
    onEvent: (ListScreenEvent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state) {
        onEvent(ListScreenEvent.LoadVolunteeringListByType(getTypeById(typeId)))
        val message = state.errorText
        message?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            onEvent(ListScreenEvent.ErrorSeen)
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
                            text = getTypeById(typeId).title,
                            fontWeight = FontWeight.Bold,
                            color = lightColors.onBackground
                        )
                    }
                },
                navigationIcon = {
                    BackArrowIcon {
                        onEvent(ListScreenEvent.ClickBackButton)
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp, start = 8.dp)
                ) {
                    items(count = 9) {
                        Tag(text = getTypeById((it + 1).toString()).title)
                    }
                }
            }
            items(count = state.volunteeringList.size) {
                Spacer(modifier = Modifier.height(16.dp))
                VolunteeringListItem(volunteering = state.volunteeringList[it])
            }
        }
    }
}


fun getTypeById(id: String): VolunteeringType {
    return when (id) {
        VolunteeringType.EDUCATION.id -> VolunteeringType.EDUCATION
        VolunteeringType.MEDICAL.id -> VolunteeringType.MEDICAL
        VolunteeringType.SOCIAL_SERVICES.id -> VolunteeringType.SOCIAL_SERVICES
        VolunteeringType.ELDER_CARE.id -> VolunteeringType.ELDER_CARE
        VolunteeringType.HOMELESSNESS.id -> VolunteeringType.HOMELESSNESS
        VolunteeringType.IMMIGRATION.id -> VolunteeringType.IMMIGRATION
        VolunteeringType.ANIMAL_RESCUE.id -> VolunteeringType.ANIMAL_RESCUE
        VolunteeringType.DISASTER_RELIEF.id -> VolunteeringType.DISASTER_RELIEF
        VolunteeringType.HUNGER.id -> VolunteeringType.HUNGER
        else -> VolunteeringType.EDUCATION
    }
}
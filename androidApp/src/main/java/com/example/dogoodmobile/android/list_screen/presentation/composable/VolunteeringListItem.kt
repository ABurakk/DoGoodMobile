package com.example.dogoodmobile.android.list_screen.presentation.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogoodmobile.android.core.theme.lightColors
import com.example.dogoodmobile.core.domain.Volunteering

@Composable
fun VolunteeringListItem(
    volunteering: Volunteering,
    onVolunteeringButtonClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .border(
                border = BorderStroke(0.8.dp, color = lightColors.onBackground),
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onVolunteeringButtonClick(volunteering.id.toString())
            }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = volunteering.day, fontWeight = FontWeight.SemiBold,
                    color = lightColors.onBackground,
                    fontSize = 26.sp
                )
                Text(
                    text = volunteering.month, fontWeight = FontWeight.Normal,
                    color = lightColors.onBackground,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }

            Text(
                text = volunteering.title, color = lightColors.onBackground,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(16.dp)
                    .width(200.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            text = volunteering.location.city, color = lightColors.onBackground,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp, end = 4.dp)
                .align(Alignment.CenterEnd)
        )
    }
}
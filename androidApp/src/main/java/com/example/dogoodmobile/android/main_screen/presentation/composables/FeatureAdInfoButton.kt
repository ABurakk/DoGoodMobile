package com.example.dogoodmobile.android.main_screen.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogoodmobile.android.core.theme.lightColors
import com.example.dogoodmobile.core.domain.Volunteering

@Composable
fun FeaturedAdInfoButton(
    volunteering: Volunteering?,
    modifier: Modifier,
    onDetailClicked: (String) -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = lightColors.secondary)
            .height(96.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = volunteering?.title ?: "",
                    fontWeight = FontWeight.SemiBold,
                    color = lightColors.onBackground,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp)
                        .width(210.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                Text(
                    text = "by " + volunteering?.ownerName + " at " + volunteering?.location?.country,
                    fontWeight = FontWeight.Normal,
                    color = lightColors.onBackground,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, bottom = 10.dp)
                        .width(210.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }

            Button(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(size = 12.dp))
                    .size(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightColors.primary),
                onClick = { onDetailClicked(volunteering?.type?.id.toString()) }) {
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.KeyboardDoubleArrowRight,
                    contentDescription = "",
                )
            }
        }
    }
}
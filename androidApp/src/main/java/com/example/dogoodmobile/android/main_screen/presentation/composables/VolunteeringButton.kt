package com.example.dogoodmobile.android.main_screen.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogoodmobile.android.core.theme.lightColors

@Composable
fun VolunteeringButton(
    iconSource: Int? = null,
    imageVector: ImageVector? = null,
    color: Color,
    name: String,
    isTextVisible: Boolean = true,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(64.dp)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = lightColors.secondary),
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 12.dp))
                .size(64.dp),
            onClick = {
                onClick()
            },
        ) {
            if (iconSource != null) {
                Icon(
                    painter = painterResource(id = iconSource),
                    contentDescription = "",
                    tint = color
                )
            } else {
                Icon(
                    modifier = Modifier.fillMaxSize(0.8F),
                    imageVector = imageVector!!,
                    contentDescription = "",
                    tint = color
                )
            }
        }
        if (isTextVisible) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = name,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}
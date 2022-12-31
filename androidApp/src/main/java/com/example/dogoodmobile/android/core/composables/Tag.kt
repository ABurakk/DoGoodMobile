package com.example.dogoodmobile.android.core.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dogoodmobile.android.core.theme.lightColors

@Composable
fun Tag(text: String) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = lightColors.secondary),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
    ) {
        Text(text = text)
    }
}
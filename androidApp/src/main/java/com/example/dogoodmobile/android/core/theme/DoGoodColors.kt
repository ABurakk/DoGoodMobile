package com.example.dogoodmobile.android.core.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import com.example.dogoodmobile.core.util.Colors

val Green = Color(0xE6065A63)
val LightBlue = Color(Colors.LightBlue)
val LightBlueGrey = Color(Colors.LightBlueGrey)
val TextBlack = Color(Colors.TextBlack)
val DarkGrey = Color(Colors.DarkGrey)

val lightColors = lightColors(
    primary = Green,
    background = LightBlueGrey,
    onPrimary = Color.White,
    onBackground = DarkGrey,
    surface = Color.White,
    onSurface = TextBlack
)

val darkColors = darkColors(
    primary = Green,
    background = DarkGrey,
    onPrimary = Color.White,
    onBackground = Color.White,
    surface = DarkGrey,
    onSurface = Color.White
)
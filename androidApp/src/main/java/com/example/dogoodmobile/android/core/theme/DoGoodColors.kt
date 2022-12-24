package com.example.dogoodmobile.android.core.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import com.example.dogoodmobile.core.util.Colors

val Green = Color(0xE6065A63)
val LightBlue = Color(Colors.LightBlue)
val LightBlueGrey = Color(Colors.LightBlueGrey)
val TextBlack = Color(Colors.TextBlack)
val DarkGrey = Color(Colors.DarkGrey)
val Pink = Color(0xE6DF26C6)
val Orange = Color(0xFFF4511E)
val LightBlue2 = Color(0xFF039BE5)
val Purple = Color(0xFF48129E)
val Red = Color(0xFF990815)


@SuppressLint("ConflictingOnColor")
val lightColors = lightColors(
    primary = Green,
    secondary = LightBlueGrey,
    background = Color.White,
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
package com.example.jbsb.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jbsb.R

val sans = FontFamily(
    Font(R.font.comicsans)
)

// Define a baseline text style using your 'sans' font variable
val defaultTextStyle = TextStyle(
    fontFamily = sans,
    fontWeight = FontWeight.Normal
)

val Typography = Typography(
    displayLarge = defaultTextStyle.copy(fontSize = 57.sp, lineHeight = 64.sp),
    displayMedium = defaultTextStyle.copy(fontSize = 45.sp, lineHeight = 52.sp),
    displaySmall = defaultTextStyle.copy(fontSize = 36.sp, lineHeight = 44.sp),
    headlineLarge = defaultTextStyle.copy(fontSize = 32.sp, lineHeight = 40.sp),
    headlineMedium = defaultTextStyle.copy(fontSize = 28.sp, lineHeight = 36.sp),
    headlineSmall = defaultTextStyle.copy(fontSize = 24.sp, lineHeight = 32.sp),
    titleLarge = defaultTextStyle.copy(fontSize = 22.sp, lineHeight = 28.sp),
    titleMedium = defaultTextStyle.copy(fontSize = 16.sp, lineHeight = 24.sp, fontWeight = FontWeight.Medium),
    titleSmall = defaultTextStyle.copy(fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
    bodyLarge = defaultTextStyle.copy(fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = defaultTextStyle.copy(fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = defaultTextStyle.copy(fontSize = 12.sp, lineHeight = 16.sp),
    labelLarge = defaultTextStyle.copy(fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
    labelMedium = defaultTextStyle.copy(fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium),
    labelSmall = defaultTextStyle.copy(fontSize = 11.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium)
)
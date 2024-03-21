package com.example.grupo22_kotlin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.grupo22_kotlin.R

val Montserrat = FontFamily(
    Font(R.font.montserratlight, FontWeight.Light),
    Font(R.font.montserratregular, FontWeight.Normal),
    Font(R.font.montserratsemibold, FontWeight.SemiBold),
    Font(R.font.montserratmedium, FontWeight.Medium),
    Font(R.font.montserratblack, FontWeight.Black),
    Font(R.font.montserratbold, FontWeight.Bold),
    Font(R.font.montserratextrabold, FontWeight.ExtraBold)
)

val Raleway = FontFamily(
    Font(R.font.ralewaylight, FontWeight.Light),
    Font(R.font.ralewayregular, FontWeight.Normal),
    Font(R.font.ralewaymedium, FontWeight.Medium),
    Font(R.font.ralewaysemibold, FontWeight.SemiBold),
    Font(R.font.ralewayblack, FontWeight.Black),
    Font(R.font.ralewaybold, FontWeight.Bold),
    Font(R.font.ralewayextrabold, FontWeight.ExtraBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)
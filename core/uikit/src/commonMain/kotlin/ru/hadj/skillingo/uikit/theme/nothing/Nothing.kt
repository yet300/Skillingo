package ru.hadj.skillingo.uikit.theme.nothing

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.fontFamilyResource

@Composable
fun NothingTypography() = Typography(
    displayLarge = TextStyle(
        fontFamily = fontFamilyResource(Res.fonts.nothing_font),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 30.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = fontFamilyResource(Res.fonts.nothing_font),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = fontFamilyResource(Res.fonts.nothing_font),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = fontFamilyResource(Res.fonts.nothing_font),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
)
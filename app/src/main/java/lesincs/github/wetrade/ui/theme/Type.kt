package lesincs.github.wetrade.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
@ExperimentalUnitApi
val Typography = Typography(
    defaultFontFamily = MontserratFontFamily,
    h1 = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 40.sp,
        letterSpacing = TextUnit(1.25f, TextUnitType.Sp)
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp,
        letterSpacing = TextUnit(0f, TextUnitType.Sp)
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        letterSpacing = TextUnit(0f, TextUnitType.Sp)
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = TextUnit(0f, TextUnitType.Sp)
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 13.sp,
        letterSpacing = TextUnit(0f, TextUnitType.Sp)
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        letterSpacing = TextUnit(1.25f, TextUnitType.Sp)
    )
)
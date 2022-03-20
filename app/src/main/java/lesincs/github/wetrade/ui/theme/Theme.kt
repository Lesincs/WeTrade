package lesincs.github.wetrade.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi

private val DarkColorPalette = darkColors(
    primary = Yellow,
    onPrimary = Gray900,
    background = Gray900,
    surface = Gray700,
    onBackground = White,
    onSurface = White,
)

private val LightColorPalette = lightColors(
    primary = Yellow,
    onPrimary = Gray900,
    background = Purple,
    surface = White,
    onBackground = White,
    onSurface = Gray900
)

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WeTradeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
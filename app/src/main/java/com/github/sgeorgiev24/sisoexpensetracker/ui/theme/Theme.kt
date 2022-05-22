package com.github.sgeorgiev24.sisoexpensetracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = BlueGrotto,
    primaryVariant = BabyBlue,
    secondary = RoyalBlue
)

private val LightColorPalette = lightColors(
    primary = BlueGrotto,
    primaryVariant = BabyBlue,
    secondary = RoyalBlue,
    surface = SilverPink
)

@Composable
fun SisoExpenseTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
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
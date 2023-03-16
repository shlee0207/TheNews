package com.hyunny.core.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Blue80,
    onPrimary = Color.White,
    primaryContainer = BlueGray30,
    onPrimaryContainer = Blue20,
    secondary = Gray30,
    onSecondary = Color.White,
    secondaryContainer = Gray80,
    onSecondaryContainer = Blue10,
    tertiary = DarkBlue30,
    onTertiary = Color.White,
    tertiaryContainer = BlueGray40,
    onTertiaryContainer = Blue30,
    error = Red40,
    errorContainer = Orange20,
    onError = Color.White,
    onErrorContainer = Red10,
    background = Color.White,
    onBackground = Blue40,
    surface = Color.White,
    onSurface = Blue40,
    surfaceVariant = Gray90,
    onSurfaceVariant = Gray20,
    outline = Gray40,
    inverseOnSurface = Color.White,
    inverseSurface = Blue50,
    inversePrimary = BlueGray10,
    surfaceTint = Blue80,
    outlineVariant = Gray60,
    scrim = Color.Black,
)


private val DarkColors = darkColorScheme(
    primary = BlueGray10,
    onPrimary = Blue60,
    primaryContainer = Blue70,
    onPrimaryContainer = BlueGray30,
    secondary = Gray70,
    onSecondary = DarkBlue10,
    secondaryContainer = Gray10,
    onSecondaryContainer = Gray80,
    tertiary = BlueGray20,
    onTertiary = Blue50,
    tertiaryContainer = DarkBlue20,
    onTertiaryContainer = BlueGray40,
    error = Orange10,
    errorContainer = Red30,
    onError = Red20,
    onErrorContainer = Orange20,
    background = Blue40,
    onBackground = BlueGray40,
    surface = Blue40,
    onSurface = BlueGray40,
    surfaceVariant = Gray20,
    onSurfaceVariant = Gray60,
    outline = Gray50,
    inverseOnSurface = Blue40,
    inverseSurface = BlueGray40,
    inversePrimary = Blue80,
    surfaceTint = BlueGray10,
    outlineVariant = Gray20,
    scrim = Color.Black,
)

@Composable
fun TheNewsTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}

package io.github.tfreitasf.aluvery.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Indigo400,
    onPrimary = Color.White,
    primaryContainer = Indigo400Light,
    onPrimaryContainer = Color.Black,
    secondary = Indigo500,
    onSecondary = Color.White,
    secondaryContainer = Indigo500,
    onSecondaryContainer = Color.Black,
    tertiary = Purple200,
    onTertiary = Color.White,
    error = Color.Red,
    onError = Color.White,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF121212),
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Indigo400,
    onPrimary = Color.White,
    primaryContainer = Indigo400Light,
    onPrimaryContainer = Color.Black,
    secondary = Indigo500,
    onSecondary = Color.White,
    secondaryContainer = Indigo500,
    onSecondaryContainer = Color.Black,
    tertiary = Purple200,
    onTertiary = Color.White,
    error = Color.Red,
    onError = Color.White,
    background = Color(0xFFFFFBFE),
    onBackground = Color.Black,
    surface = Color(0xFFFFFBFE),
    onSurface = Color.Black
)

@Composable
fun AluveryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
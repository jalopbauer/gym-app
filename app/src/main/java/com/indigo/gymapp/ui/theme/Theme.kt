package com.indigo.gymapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.indigo.gymapp.ui.theme.color.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color.Theme.Nord.`greyscale-500`(),
    onPrimary = Color.Theme.Nord.`neutral-300`(),
    secondary = Color.Theme.Nord.`primary-500`(),
    onSecondary = Color.Theme.Nord.`primary-600`(),
    background = Color.Theme.Nord.`neutral-600`(),
    onBackground = Color.Theme.Nord.`greyscale-500`(),
    surface = Color.Theme.Nord.`neutral-500`(),
)

private val LightColorScheme = lightColorScheme(
    primary = Color.Theme.Nord.`neutral-500`(),
    onPrimary = Color.Theme.Nord.`neutral-200`(),
    secondary = Color.Theme.Nord.`primary-500`(),
    onSecondary = Color.Theme.Nord.`primary-600`(),
    background = Color.Theme.Nord.`greyscale-500`(),
    onBackground = Color.Theme.Nord.`greyscale-500`(),
    surface = Color.Theme.Nord.`greyscale-700`(),
)

@Composable
fun GymAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
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
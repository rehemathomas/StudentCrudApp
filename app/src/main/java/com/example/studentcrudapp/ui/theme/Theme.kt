package com.example.studentcrudapp.ui.theme

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

// ========================================
// LIGHT THEME - Professional & Academic
// ========================================
private val LightColorScheme = lightColorScheme(
    // Primary - Blue (Academic & Trustworthy)
    primary = PrimaryLight,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD3E4F4),
    onPrimaryContainer = Color(0xFF001D36),

    // Secondary - Teal (Fresh & Modern)
    secondary = SecondaryLight,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFB2DFDB),
    onSecondaryContainer = Color(0xFF004D40),

    // Tertiary - Orange (Warm Accents)
    tertiary = TertiaryLight,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFFCCBC),
    onTertiaryContainer = Color(0xFF4E2615),

    // Error
    error = Color(0xFFD32F2F),
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),

    // Background & Surface
    background = Color(0xFFFBFCFE),
    onBackground = Color(0xFF1A1C1E),
    surface = Color.White,
    onSurface = Color(0xFF1A1C1E),
    surfaceVariant = Color(0xFFE1E2EC),
    onSurfaceVariant = Color(0xFF44474F),

    // Outline
    outline = Color(0xFF757575),
    outlineVariant = Color(0xFFC4C6D0)
)

// ========================================
// DARK THEME - Sleek & Eye-Friendly
// ========================================
private val DarkColorScheme = darkColorScheme(
    // Primary - Light Blue (Easy on eyes)
    primary = PrimaryDark,
    onPrimary = Color(0xFF003258),
    primaryContainer = Color(0xFF004A77),
    onPrimaryContainer = Color(0xFFD3E4F4),

    // Secondary - Light Teal
    secondary = SecondaryDark,
    onSecondary = Color(0xFF003731),
    secondaryContainer = Color(0xFF005048),
    onSecondaryContainer = Color(0xFFB2DFDB),

    // Tertiary - Peach
    tertiary = TertiaryDark,
    onTertiary = Color(0xFF4E2615),
    tertiaryContainer = Color(0xFF73342A),
    onTertiaryContainer = Color(0xFFFFCCBC),

    // Error
    error = Color(0xFFEF5350),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),

    // Background & Surface (OLED Friendly)
    background = Color(0xFF121212),
    onBackground = Color(0xFFE3E2E6),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE3E2E6),
    surfaceVariant = Color(0xFF2C2C2C),
    onSurfaceVariant = Color(0xFFC4C6D0),

    // Outline
    outline = Color(0xFF938F99),
    outlineVariant = Color(0xFF44474F)
)

@Composable
fun StudentCrudAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // Set to false if you want to always use your custom colors
    dynamicColor: Boolean = false,  // Changed to false for consistent branding
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

package com.example.whatsappui.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Black,
    secondary = LightBlack,
    background = LightGray,
    tertiary =  White

)

private val LightColorScheme = lightColorScheme(
    primary = White,
    secondary = DarkThinGray,
    background = White,
    tertiary = LightGreen


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun WhatsAppUITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme){
        DarkColorScheme}
    else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {

        val systemUiController = rememberSystemUiController()
        val statusBarColor = if (isSystemInDarkTheme()){
            Gray
        }else White
        val navigationBarColors = if (isSystemInDarkTheme()){ LightGray}
            else White


        SideEffect {
            systemUiController.setSystemBarsColor(
                statusBarColor
            )
            systemUiController.setSystemBarsColor(
              navigationBarColors
            )
        }
    }



    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
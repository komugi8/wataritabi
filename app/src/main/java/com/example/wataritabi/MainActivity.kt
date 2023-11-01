package com.example.wataritabi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.wataritabi.navigation.NavigationScreen
import com.example.wataritabi.ui.theme.WataritabiTheme
import com.google.android.libraries.places.api.Places

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the SDK
        Places.initialize(applicationContext, BuildConfig.MAPS_API_KEY)
        setContent {
            WataritabiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavigationScreen()
                }
            }
        }
    }
}

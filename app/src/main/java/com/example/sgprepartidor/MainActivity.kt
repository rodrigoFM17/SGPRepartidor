package com.example.sgprepartidor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sgprepartidor.core.navigation.NavigationWrapper
import com.example.sgprepartidor.ui.theme.SGPRepartidorTheme
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.WellKnownTileServer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Mapbox.getInstance(this, null, WellKnownTileServer.MapLibre)
        setContent {
            SGPRepartidorTheme {
                NavigationWrapper()
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NavigationWrapper()
//}
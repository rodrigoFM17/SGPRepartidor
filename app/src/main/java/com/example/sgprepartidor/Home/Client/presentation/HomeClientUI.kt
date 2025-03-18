package com.example.sgprepartidor.Home.Client.presentation

import HomeContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.map.LiveLocationMap
import com.example.map.WebSocketLocationManager
import com.example.sgprepartidor.Home.Client.presentation.components.BottomNavBar
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.WellKnownTileServer

@Composable
fun HomeClientScreen(homeClientViewModel: HomeClientViewModel) {
    val navController = rememberNavController()
    val webSocketLocationManager = WebSocketLocationManager()



    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController, startDestination = "home") {
                composable("home") { HomeContent(homeClientViewModel) }
                composable("other") { LiveLocationMap(webSocketLocationManager) }
            }
        }
    }
}


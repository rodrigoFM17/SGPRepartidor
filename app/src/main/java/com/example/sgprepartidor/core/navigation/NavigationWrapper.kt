package com.example.sgprepartidor.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sgprepartidor.Login.Client.presentation.LoginScreen
import com.example.sgprepartidor.Login.Client.presentation.LoginClientViewModel
import com.example.sgprepartidor.Register.Client.presentation.RegisterClientScreen
import com.example.sgprepartidor.Register.Client.presentation.RegisterClientViewModel
import com.example.sgprepartidor.Register.Delivery.presentation.RegisterDeliveryScreen
import com.example.sgprepartidor.Register.Delivery.presentation.RegisterDeliveryViewModel

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = RegisterClient){
        composable<RegisterClient> {
            RegisterClientScreen(registerClientViewModel = RegisterClientViewModel())
        }
        composable<RegisterDelivery> {
            RegisterDeliveryScreen(registerDeliveryViewModel =  RegisterDeliveryViewModel())
        }
    }
}
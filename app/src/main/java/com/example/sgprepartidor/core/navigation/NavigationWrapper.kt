package com.example.sgprepartidor.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sgprepartidor.Home.Client.presentation.HomeClientScreen
import com.example.sgprepartidor.Home.Client.presentation.HomeClientViewModel
import com.example.sgprepartidor.Home.Delivery.presentation.HomeDeliveryScreen
import com.example.sgprepartidor.Home.Delivery.presentation.HomeDeliveryViewModel
import com.example.sgprepartidor.Login.presentation.LoginScreen
import com.example.sgprepartidor.Login.presentation.LoginViewModel
import com.example.sgprepartidor.Register.Client.presentation.RegisterClientScreen
import com.example.sgprepartidor.Register.Client.presentation.RegisterClientViewModel
import com.example.sgprepartidor.Register.Delivery.presentation.RegisterDeliveryScreen
import com.example.sgprepartidor.Register.Delivery.presentation.RegisterDeliveryViewModel

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login){

        composable<RegisterClient> {
            RegisterClientScreen(registerClientViewModel = RegisterClientViewModel(
                navigateToLogin = { navController.navigate(Login) }
            ))
        }
        composable<RegisterDelivery> {
            RegisterDeliveryScreen(registerDeliveryViewModel =  RegisterDeliveryViewModel(
                navigateToLogin = { navController.navigate(Login) }
            ))
        }
        composable<Login> {
            LoginScreen(loginViewModel = LoginViewModel(
                navigateRegisterClient = { navController.navigate(RegisterClient) },
                navigateRegisterDelivery = { navController.navigate(RegisterDelivery) }
            ))
        }
        composable<ClientHome> {
            HomeClientScreen(homeClientViewModel = HomeClientViewModel())
        }
        composable<DeliveryHome> {
            HomeDeliveryScreen(homeDeliveryViewModel = HomeDeliveryViewModel())
        }
    }
}
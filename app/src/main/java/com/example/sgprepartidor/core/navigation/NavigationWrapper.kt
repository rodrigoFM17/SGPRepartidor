package com.example.sgprepartidor.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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
import com.example.sgprepartidor.SupplierProducts.presentation.SupplierProductsScreen
import com.example.sgprepartidor.SupplierProducts.presentation.SupplierProductsViewModel
import com.example.sgprepartidor.core.storage.StorageManager
import com.example.sgprepartidor.model.Supplier

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val supplierStorage = StorageManager<Supplier>(context = context, storageName = "supplier", Supplier::class.java)

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
                navigateRegisterDelivery = { navController.navigate(RegisterDelivery) },
                navigateToClientHome = { navController.navigate(ClientHome) },
                navigateToDeliveryHome = { navController.navigate(DeliveryHome) }
            ))
        }
        composable<ClientHome> {
            HomeClientScreen(homeClientViewModel = HomeClientViewModel(
                navigateToSupplierProducts = { navController.navigate(SupplierProducts)},
                supplierStorage = supplierStorage
            ))
        }
        composable<DeliveryHome> {
            HomeDeliveryScreen(homeDeliveryViewModel = HomeDeliveryViewModel())
        }
        composable<SupplierProducts> {
            SupplierProductsScreen(supplierProductsViewModel = SupplierProductsViewModel(
                supplierStorage = supplierStorage
            ))
        }

    }
}
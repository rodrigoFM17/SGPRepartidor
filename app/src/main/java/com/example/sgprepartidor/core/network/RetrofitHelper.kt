package com.example.sgprepartidor.core.network

import com.example.sgprepartidor.Home.Client.data.datasource.HomeClientService
import com.example.sgprepartidor.Home.Client.presentation.HomeClientViewModel
import com.example.sgprepartidor.Home.Delivery.data.datasource.HomeDeliveryService
import com.example.sgprepartidor.Login.data.datasource.LoginService
import com.example.sgprepartidor.Register.data.datasource.RegisterService
import com.example.sgprepartidor.SupplierProducts.data.datasource.SupplierService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = "http://3.229.240.157:3000/"



    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginService: LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }

    val supplierService: SupplierService by lazy {
        retrofit.create(SupplierService::class.java)
    }

    val registerService: RegisterService by lazy {
        retrofit.create(RegisterService::class.java)
    }

    val homeDeliveryService: HomeDeliveryService by lazy {
        retrofit.create(HomeDeliveryService::class.java)
    }

    val homeClientService: HomeClientService by lazy {
        retrofit.create(HomeClientService::class.java)
    }

}
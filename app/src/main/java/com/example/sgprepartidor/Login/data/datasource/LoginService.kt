package com.example.sgprepartidor.Login.data.datasource

import com.example.sgprepartidor.Login.data.model.Client
import com.example.sgprepartidor.Login.data.model.Delivery
import com.example.sgprepartidor.Login.data.model.LoginDTO
import com.example.sgprepartidor.core.network.model.APIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("client/auth")
    suspend fun loginClient(@Body request : LoginDTO): Response<APIResponse<Client>>

    @POST("driver/auth")
    suspend fun loginDelivery(@Body request : LoginDTO): Response<APIResponse<Delivery>>
}
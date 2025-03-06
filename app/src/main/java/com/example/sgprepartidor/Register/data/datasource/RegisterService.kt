package com.example.sgprepartidor.Register.data.datasource

import com.example.sgprepartidor.Home.Client.data.model.Supplier
import com.example.sgprepartidor.Login.data.model.Client
import com.example.sgprepartidor.Login.data.model.Delivery
import com.example.sgprepartidor.Register.Client.data.model.RegisterClientDTO
import com.example.sgprepartidor.Register.Delivery.data.model.RegisterDeliveryDTO
import com.example.sgprepartidor.core.network.model.APIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("v1/delivery")
    suspend fun registerDelivery(@Body request: RegisterDeliveryDTO): Response<APIResponse<Delivery>>

    @POST("v1/clients")
    suspend fun registerClient(@Body request: RegisterClientDTO): Response<APIResponse<Client>>
}
package com.example.sgprepartidor.Register.data.datasource

import com.example.sgprepartidor.Register.Client.data.model.ClientResponse
import com.example.sgprepartidor.Register.Client.data.model.RegisterClientDTO
import com.example.sgprepartidor.Register.Delivery.data.model.RegisterDeliveryDTO
import com.example.sgprepartidor.core.network.model.APIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("driver")
    suspend fun registerDelivery(@Body request: RegisterDeliveryDTO): Response<APIResponse<RegisterDeliveryDTO>>

    @POST("client")
    suspend fun registerClient(@Body request: RegisterClientDTO): Response<APIResponse<ClientResponse>>
}
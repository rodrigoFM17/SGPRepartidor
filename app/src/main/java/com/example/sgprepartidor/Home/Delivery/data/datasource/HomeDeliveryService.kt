package com.example.sgprepartidor.Home.Delivery.data.datasource

import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.Home.Delivery.data.model.UpdateStatusDTO
import com.example.sgprepartidor.core.network.model.APIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface HomeDeliveryService {

    @GET("v1/deliveryOrder/current/{deliveryId}")
    suspend fun getCurrentDeliveryOrder(@Path("deliveryId") deliveryId: String): Response<APIResponse<DeliveryOrder>>

    @PATCH("v1/deliveryOrder/{deliveryId}")
    suspend fun updateStatusDeliveryOrder(
        @Path("deliveryId") deliveryId: String,
        @Body request: UpdateStatusDTO
    ):Response<APIResponse<Boolean>>
}
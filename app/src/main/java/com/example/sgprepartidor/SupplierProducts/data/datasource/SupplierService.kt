package com.example.sgprepartidor.SupplierProducts.data.datasource

import com.example.sgprepartidor.SupplierProducts.data.model.DeliveryDTO
import com.example.sgprepartidor.SupplierProducts.data.model.NewDeliveryDTO
import com.example.sgprepartidor.core.network.model.APIResponse
import com.example.sgprepartidor.shared.model.Product
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SupplierService {

    @GET("products/{supplierId}")
    suspend fun getAllProductsBySupplierId(@Path("supplierId") supplierId: String): Response<APIResponse<List<Product>>>

    @POST("delivery")
    suspend fun createNewDelivery(@Body request: NewDeliveryDTO): Response<APIResponse<DeliveryDTO>>
}
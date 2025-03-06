package com.example.sgprepartidor.SupplierProducts.data.datasource

import com.example.sgprepartidor.SupplierProducts.data.model.Product
import com.example.sgprepartidor.core.network.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SupplierService {

    @GET("v1/products/{supplierId}")
    suspend fun getAllProductsBySupplierId(@Path("supplierId") supplierId: String): Response<APIResponse<Product>>
}
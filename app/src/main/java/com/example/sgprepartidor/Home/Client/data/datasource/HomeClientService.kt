package com.example.sgprepartidor.Home.Client.data.datasource

import com.example.sgprepartidor.core.network.model.APIResponse
import com.example.sgprepartidor.model.Supplier
import retrofit2.Response
import retrofit2.http.GET

interface HomeClientService {

    @GET("supplier")
    suspend fun getAllSuppliers(): Response<APIResponse<List<Supplier>>>
}
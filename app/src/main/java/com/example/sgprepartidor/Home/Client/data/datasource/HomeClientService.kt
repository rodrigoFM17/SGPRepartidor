package com.example.sgprepartidor.Home.Client.data.datasource

import com.example.sgprepartidor.core.network.model.APIResponse
import com.example.sgprepartidor.shared.model.Supplier
import retrofit2.Response
import retrofit2.http.GET

interface HomeClientService {

    @GET("supplier/?limit=10&page=1&orderDir=asc&orderBy=id")
    suspend fun getAllSuppliers(): Response<APIResponse<List<Supplier>>>
}
package com.example.sgprepartidor.Home.Client.data.repository

import com.example.sgprepartidor.core.network.RetrofitHelper
import com.example.sgprepartidor.core.network.model.APIResponse
import com.example.sgprepartidor.shared.model.Supplier

class HomeClientRepositry {
    private val homeClientService = RetrofitHelper.homeClientService

    suspend fun getAllSuppliers(): Result<APIResponse<List<Supplier>>> {
        return try {
            val response = homeClientService.getAllSuppliers()

            if(response.isSuccessful){
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
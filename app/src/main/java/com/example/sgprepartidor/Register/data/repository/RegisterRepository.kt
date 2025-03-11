package com.example.sgprepartidor.Register.data.repository

import com.example.sgprepartidor.Login.data.model.Client
import com.example.sgprepartidor.Login.data.model.Delivery
import com.example.sgprepartidor.Login.data.model.LoginDTO
import com.example.sgprepartidor.Register.Client.data.model.ClientResponse
import com.example.sgprepartidor.Register.Client.data.model.RegisterClientDTO
import com.example.sgprepartidor.Register.Delivery.data.model.RegisterDeliveryDTO
import com.example.sgprepartidor.core.network.RetrofitHelper
import com.example.sgprepartidor.core.network.model.APIResponse

class RegisterRepository {

    val registerService = RetrofitHelper.registerService

    suspend fun registerClient (registerClientDTO: RegisterClientDTO): Result<APIResponse<ClientResponse>> {
        return try {
            val response = registerService.registerClient(registerClientDTO)

            if(response.isSuccessful){
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun registerDelivery (registerDeliveryDTO: RegisterDeliveryDTO): Result<APIResponse<RegisterDeliveryDTO>> {
        return try {
            val response = registerService.registerDelivery(registerDeliveryDTO)

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
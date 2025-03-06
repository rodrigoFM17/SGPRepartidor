package com.example.sgprepartidor.Login.data.repository

import com.example.sgprepartidor.Login.data.model.Client
import com.example.sgprepartidor.Login.data.model.Delivery
import com.example.sgprepartidor.Login.data.model.LoginDTO
import com.example.sgprepartidor.core.network.RetrofitHelper
import com.example.sgprepartidor.core.network.model.APIResponse

class LoginRepository {
    private val loginService = RetrofitHelper.loginService

    suspend fun loginClient (loginDTO : LoginDTO): Result<APIResponse<Client>> {
        return try {
            val response = loginService.loginClient(loginDTO)

            if(response.isSuccessful){
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun loginDelivery (loginDTO : LoginDTO): Result<APIResponse<Delivery>> {
        return try {
            val response = loginService.loginDelivery(loginDTO)

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
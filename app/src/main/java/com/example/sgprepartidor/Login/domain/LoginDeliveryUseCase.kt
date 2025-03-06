package com.example.sgprepartidor.Login.domain

import com.example.sgprepartidor.Login.data.model.Delivery
import com.example.sgprepartidor.Login.data.model.LoginDTO
import com.example.sgprepartidor.Login.data.repository.LoginRepository
import com.example.sgprepartidor.core.network.model.APIResponse

class LoginDeliveryUseCase {
    val repository = LoginRepository()
    suspend operator fun invoke (loginDTO: LoginDTO): Result<APIResponse<Delivery>> {
        val result = repository.loginDelivery(loginDTO)
        return result
    }
}
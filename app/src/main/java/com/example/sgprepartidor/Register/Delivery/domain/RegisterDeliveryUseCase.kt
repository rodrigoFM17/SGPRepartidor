package com.example.sgprepartidor.Register.Delivery.domain

import com.example.sgprepartidor.Login.data.model.Client
import com.example.sgprepartidor.Login.data.model.Delivery
import com.example.sgprepartidor.Login.data.model.LoginDTO
import com.example.sgprepartidor.Login.data.repository.LoginRepository
import com.example.sgprepartidor.Register.Delivery.data.model.RegisterDeliveryDTO
import com.example.sgprepartidor.Register.data.repository.RegisterRepository
import com.example.sgprepartidor.core.network.model.APIResponse

class RegisterDeliveryUseCase {
    val repository = RegisterRepository()
    suspend operator fun invoke (registerDeliveryDTO: RegisterDeliveryDTO): Result<APIResponse<Delivery>> {
        val result = repository.registerDelivery(registerDeliveryDTO)
        return result
    }
}
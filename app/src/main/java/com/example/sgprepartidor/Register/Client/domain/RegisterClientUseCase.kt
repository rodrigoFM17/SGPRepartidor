package com.example.sgprepartidor.Register.Client.domain

import com.example.sgprepartidor.Register.Client.data.model.ClientResponse
import com.example.sgprepartidor.Register.Client.data.model.RegisterClientDTO
import com.example.sgprepartidor.Register.data.repository.RegisterRepository
import com.example.sgprepartidor.core.network.model.APIResponse

class RegisterClientUseCase {
    val repository = RegisterRepository()

    suspend operator fun invoke (registerClientDTO: RegisterClientDTO): Result<APIResponse<ClientResponse>> {
        val result = repository.registerClient(registerClientDTO)
        return result
    }
}
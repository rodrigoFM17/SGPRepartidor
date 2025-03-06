package com.example.sgprepartidor.Login.domain

import com.example.sgprepartidor.Login.data.model.Client
import com.example.sgprepartidor.Login.data.model.LoginDTO
import com.example.sgprepartidor.Login.data.repository.LoginRepository
import com.example.sgprepartidor.core.network.model.APIResponse

class LoginClientUseCase {
    val repository = LoginRepository()
    suspend operator fun invoke (loginDTO: LoginDTO): Result<APIResponse<Client>> {
        val result = repository.loginClient(loginDTO)
        return result
    }
}
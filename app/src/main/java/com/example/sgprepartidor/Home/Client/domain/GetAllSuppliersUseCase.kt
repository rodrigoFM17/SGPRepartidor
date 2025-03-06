package com.example.sgprepartidor.Home.Client.domain

import com.example.sgprepartidor.Home.Client.data.repository.HomeClientRepositry
import com.example.sgprepartidor.core.network.model.APIResponse
import com.example.sgprepartidor.model.Supplier

class GetAllSuppliersUseCase {
    val homeClientRepository = HomeClientRepositry()
    suspend operator fun invoke(): Result<APIResponse<Supplier>> {
        val result = homeClientRepository.getAllSuppliers()
        return result
    }
}
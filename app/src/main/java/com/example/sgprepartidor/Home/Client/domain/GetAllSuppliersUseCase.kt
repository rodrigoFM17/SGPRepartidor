package com.example.sgprepartidor.Home.Client.domain

import com.example.sgprepartidor.Home.Client.data.model.Supplier
import com.example.sgprepartidor.Home.Client.data.repository.HomeClientRepositry
import com.example.sgprepartidor.core.network.model.APIResponse

class GetAllSuppliersUseCase {
    val homeClientRepository = HomeClientRepositry()
    suspend operator fun invoke(): Result<APIResponse<Supplier>> {
        val result = homeClientRepository.getAllSuppliers()
        return result
    }
}
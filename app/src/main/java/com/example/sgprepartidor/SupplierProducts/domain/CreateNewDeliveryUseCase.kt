package com.example.sgprepartidor.SupplierProducts.domain

import com.example.sgprepartidor.SupplierProducts.data.model.DeliveryDTO
import com.example.sgprepartidor.SupplierProducts.data.model.NewDeliveryDTO
import com.example.sgprepartidor.SupplierProducts.data.repository.SupplierRepository
import com.example.sgprepartidor.core.network.model.APIResponse

class CreateNewDeliveryUseCase {
    val repository = SupplierRepository()
    suspend operator fun invoke (newDeliveryDTO: NewDeliveryDTO): Result<APIResponse<DeliveryDTO>> {
        val result = repository.createNewDelivery(newDeliveryDTO)
        return result
    }
}
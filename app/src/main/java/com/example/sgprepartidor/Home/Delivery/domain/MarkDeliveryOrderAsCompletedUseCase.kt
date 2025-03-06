package com.example.sgprepartidor.Home.Delivery.domain

import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.Home.Delivery.data.model.UpdateStatusDTO
import com.example.sgprepartidor.Home.Delivery.data.repository.HomeDeliveryRepository
import com.example.sgprepartidor.core.network.model.APIResponse

class MarkDeliveryOrderAsCompletedUseCase {
    val repository = HomeDeliveryRepository()
    suspend operator fun invoke (deliveryId: String, updateStatusDTO: UpdateStatusDTO): Result<APIResponse<Boolean>> {
        val result = repository.markDeliveryOrderAsCompleted(deliveryId, updateStatusDTO)
        return result
    }
}
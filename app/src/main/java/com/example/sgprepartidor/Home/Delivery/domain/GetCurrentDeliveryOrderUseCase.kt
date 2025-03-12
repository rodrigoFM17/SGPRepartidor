package com.example.sgprepartidor.Home.Delivery.domain

import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.Home.Delivery.data.repository.HomeDeliveryRepository
import com.example.sgprepartidor.core.network.model.APIResponse

class GetCurrentDeliveryOrderUseCase {
    val repository = HomeDeliveryRepository()
    suspend operator fun invoke (deliveryId: String): Result<APIResponse<List<DeliveryOrder>>> {
        val result = repository.getCurrentDeliveryOrder(deliveryId)
        return result
    }
}
package com.example.sgprepartidor.Home.Delivery.domain

import android.content.Context
import com.example.sgprepartidor.core.data.local.deliverysCompleted.entities.DeliveryCompletedEntity

class InsertDeliveryCompletedUseCase(context: Context) {
    val repository = DeliverysCompletedRepository(context)
    suspend operator fun invoke (deliveryCompleted: DeliveryCompletedEntity) {
        repository.insertDeliveryOrdered(deliveryCompleted)
    }
}
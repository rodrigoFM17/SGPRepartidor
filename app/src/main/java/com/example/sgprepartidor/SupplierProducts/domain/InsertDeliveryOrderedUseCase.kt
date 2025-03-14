package com.example.sgprepartidor.SupplierProducts.domain

import android.content.Context
import com.example.sgprepartidor.shared.repository.DeliverysOrderedRepository
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity

class InsertDeliveryOrderedUseCase(context: Context) {
    val repository = DeliverysOrderedRepository(context)
    suspend operator fun invoke (deliveryOrdered: DeliveryOrderedEntity) {
        repository.insertDeliveryOrdered(deliveryOrdered)
    }
}
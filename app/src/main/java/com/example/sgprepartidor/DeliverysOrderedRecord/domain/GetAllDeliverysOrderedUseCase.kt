package com.example.sgprepartidor.DeliverysOrderedRecord.domain

import android.content.Context
import com.example.sgprepartidor.shared.repository.DeliverysOrderedRepository
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity

class GetAllDeliverysOrderedUseCase(context: Context) {
    val repository = DeliverysOrderedRepository(context)
    suspend operator fun invoke (): List<DeliveryOrderedEntity> {
        val result = repository.getAllDeliverysOrdered()
        return result
    }
}
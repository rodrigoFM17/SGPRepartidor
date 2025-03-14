package com.example.sgprepartidor.DeliverysCompletedRecord.domain

import android.content.Context
import com.example.sgprepartidor.core.data.local.deliverysCompleted.entities.DeliveryCompletedEntity
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity
import com.example.sgprepartidor.shared.repository.DeliverysCompletedRepository
import com.example.sgprepartidor.shared.repository.DeliverysOrderedRepository

class GetAllDeliverysCompletedUseCase(context: Context) {
    val repository = DeliverysCompletedRepository(context)
    suspend operator fun invoke (): List<DeliveryCompletedEntity> {
        val result = repository.getAllDeliverysCompleted()
        return result
    }
}
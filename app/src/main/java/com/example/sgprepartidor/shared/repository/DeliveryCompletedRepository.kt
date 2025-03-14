package com.example.sgprepartidor.shared.repository

import android.content.Context
import com.example.sgprepartidor.core.data.local.appDatabase.DatabaseProvider
import com.example.sgprepartidor.core.data.local.deliverysCompleted.entities.DeliveryCompletedEntity

class DeliverysCompletedRepository(context: Context) {
    private val deliverysCompletedDAO = DatabaseProvider.getDatabase(context).deliveryCompletedDAO()

    suspend fun insertDeliveryCompleted(deliveryCompleted: DeliveryCompletedEntity) {
        deliverysCompletedDAO.insertDeliveryCompleted(deliveryCompleted)
    }

    suspend fun getAllDeliverysCompleted(): List<DeliveryCompletedEntity> {
        return deliverysCompletedDAO.getAllDeliverysCompleted()
    }
}
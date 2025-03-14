package com.example.sgprepartidor.shared.repository

import android.content.Context
import com.example.sgprepartidor.core.data.local.appDatabase.DatabaseProvider
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity

class DeliverysOrderedRepository(context: Context) {
    private val deliverysOrderedDAO = DatabaseProvider.getDatabase(context).deliveryOrderedDAO()

    suspend fun insertDeliveryOrdered(deliveryOrdered: DeliveryOrderedEntity) {
        deliverysOrderedDAO.insertDeliveryOrdered(deliveryOrdered)
    }

    suspend fun getAllDeliverysOrdered(): List<DeliveryOrderedEntity> {
        return deliverysOrderedDAO.getAllDeliveryOrdered()
    }
}
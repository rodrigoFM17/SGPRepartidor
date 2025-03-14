package com.example.sgprepartidor.core.data.local.appDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sgprepartidor.core.data.local.deliverysCompleted.DAO.DeliveryCompletedDAO
import com.example.sgprepartidor.core.data.local.deliverysCompleted.entities.DeliveryCompletedEntity
import com.example.sgprepartidor.core.data.local.deliverysOrdered.DAO.DeliverysOrderedDAO
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity

@Database(
    entities = [
    DeliveryCompletedEntity::class,
    DeliveryOrderedEntity::class
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun deliveryCompletedDAO(): DeliveryCompletedDAO

    abstract fun deliveryOrderedDAO(): DeliverysOrderedDAO
}
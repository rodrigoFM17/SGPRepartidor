package com.example.sgprepartidor.core.data.local.deliverysCompleted.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sgprepartidor.core.data.local.deliverysCompleted.entities.DeliveryCompletedEntity

@Dao
interface DeliveryCompletedDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliveryCompleted(deliveryCompleted: DeliveryCompletedEntity)

    @Query("SELECT * FROM deliverys_completed")
    suspend fun getAllDeliverysCompleted(): List<DeliveryCompletedEntity>
}
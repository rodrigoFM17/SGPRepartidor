package com.example.sgprepartidor.core.data.local.deliverysOrdered.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity

@Dao
interface DeliverysOrderedDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliveryOrdered(deliveryOrdered: DeliveryOrderedEntity)

    @Query("SELECT * FROM deliverys_ordered")
    suspend fun getAllDeliveryOrdered() : List<DeliveryOrderedEntity>
}
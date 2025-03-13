package com.example.sgprepartidor.core.data.local.deliverysCompleted.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

class DeliveryCompletedEntity {

    @Entity(tableName = "deliverys_completed")
    data class DeliveryCompletedEntity (
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        @ColumnInfo(name = "date")
        val date: Date,
        @ColumnInfo(name = "product_name")
        val productName: String,
        @ColumnInfo(name = "client_name")
        val clientName: String,
        @ColumnInfo(name = "supplier_name")
        val supplierName: String
    )
}
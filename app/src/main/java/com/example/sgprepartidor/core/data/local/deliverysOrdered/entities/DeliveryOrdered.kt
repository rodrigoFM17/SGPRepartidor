package com.example.sgprepartidor.core.data.local.deliverysOrdered.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliverys_ordered")
data class DeliveryOrderedEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "date")
    val date: Long,
    @ColumnInfo(name = "product_name")
    val productName: String,
    @ColumnInfo(name = "supplier_name")
    val supplierName: String
)
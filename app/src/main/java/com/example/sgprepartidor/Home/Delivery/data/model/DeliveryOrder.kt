package com.example.sgprepartidor.Home.Delivery.data.model

import com.google.gson.annotations.SerializedName

data class DeliveryOrder (
    @SerializedName("delivery_id")
    val deliveryId: String,
    @SerializedName("driver_id")
    val driverId: String,
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("supplier_id")
    val supplierId: String,
    @SerializedName("delivery_date")
    val deliveryDate: String,
    @SerializedName("status")
    val status: String
)
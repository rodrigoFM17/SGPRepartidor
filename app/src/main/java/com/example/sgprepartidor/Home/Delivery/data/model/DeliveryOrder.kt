package com.example.sgprepartidor.Home.Delivery.data.model

import com.example.sgprepartidor.Home.Client.data.model.Product

data class DeliveryOrder (
    val id: String,
    val clientName: String,
    val address: String,
    val supplierName: String,
    val deliveryDate: String,
    val deliveryProducts: List<Product>,
    val accepted: Boolean,
)
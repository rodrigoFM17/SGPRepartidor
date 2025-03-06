package com.example.sgprepartidor.SupplierProducts.data.model

data class NewDeliveryDTO (
    val client_id: Int,
    val delivery_date: String,
    val status: String,
    val supplier_id: Int,
    val driver_id: Int
)
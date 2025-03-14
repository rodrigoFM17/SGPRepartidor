package com.example.sgprepartidor.shared.model

import com.google.gson.annotations.SerializedName

data class Product (
    val id: String,
    val name: String,
    val price: Number,
    @SerializedName("supplier_id")
    val supplierId: String
)
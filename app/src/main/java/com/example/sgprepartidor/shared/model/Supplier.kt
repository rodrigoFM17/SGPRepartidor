package com.example.sgprepartidor.shared.model

import com.google.gson.annotations.SerializedName

data class Supplier (
    val id: String,
    val name: String,
    @SerializedName("contact_info")
    val contactInfo: String,
    val address: String
)
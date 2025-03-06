package com.example.sgprepartidor.Register.Delivery.data.model

data class RegisterDeliveryDTO(
    val name: String,
    val email: String,
    val password: String,
    val fcm_token: String
)
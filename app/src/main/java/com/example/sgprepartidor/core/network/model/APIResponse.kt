package com.example.sgprepartidor.core.network.model

data class APIResponse<T> (
    val success: Boolean,
    val data: List<T>,
    val message: String
)
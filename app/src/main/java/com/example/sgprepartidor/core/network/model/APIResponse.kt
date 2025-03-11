package com.example.sgprepartidor.core.network.model

data class APIResponse<T> (
    val success: Boolean,
    val data: T,
    val message: String
)
package com.example.sgprepartidor.Home.Delivery.data.model

import java.sql.Timestamp


data class LocationDTO (
    val lat: Double,
    val lng: Double,
    val timestamp: Timestamp
)
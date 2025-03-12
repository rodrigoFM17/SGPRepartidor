package com.example.sgprepartidor.Login.data.model

import com.google.gson.annotations.SerializedName

data class Client (
    @SerializedName("Id")
    val id: String,
    @SerializedName("Address")
    val address: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("Name")
    val name: String,
    val token: String
)
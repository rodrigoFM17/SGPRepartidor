package com.example.sgprepartidor.Home.Delivery.data.repository

import android.location.Location
import android.util.Log
import com.example.sgprepartidor.Home.Delivery.data.model.LocationDTO
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import java.util.concurrent.TimeUnit

class LocationWebsocketRepository(private val url: String) : WebSocketListener() {

    private var websocket: WebSocket? = null
    private val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(0, TimeUnit.MILLISECONDS)
        .build()

    fun connect() {
        val request = Request.Builder().url(url).build()
        websocket = client.newWebSocket(request, LocationWebSocket())
    }

    fun sendLocation(location: LocationDTO){
        Log.d("WS", "localizacion enviada")
        websocket?.send(location.toString())
    }

    fun closeConnection() {
        websocket?.close(1000, "cierre normal")
        websocket = null
    }

    private inner class LocationWebSocket: WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            Log.d("WEBSOCKET", "WebSocket conectado")
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            Log.d("WEBSOCKET", "Mensaje recibido: $text")
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            Log.d("WEBSOCKET", "Mensaje binario recibido: $bytes")
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            Log.d("WEBSOCKET", "WebSocket cerrando: $reason")
            webSocket.close(1000, null)
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            Log.d("WEBSOCKET", "Error en WebSocket: ${t.message}")
        }
    }
}
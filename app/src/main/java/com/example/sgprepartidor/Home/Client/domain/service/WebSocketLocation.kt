package com.example.map

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import okhttp3.*
import org.json.JSONObject
import java.util.concurrent.TimeUnit

class WebSocketLocationManager {
    private val client = OkHttpClient.Builder()
        .pingInterval(15, TimeUnit.SECONDS)
        .build()

    private val _locationFlow = MutableStateFlow<Pair<Double, Double>?>(null)
    val locationFlow: StateFlow<Pair<Double, Double>?> = _locationFlow.asStateFlow()

    private var webSocket: WebSocket? = null

    fun connectWebSocket() {
        val request = Request.Builder().url("ws://3.226.75.51/ws?order_id=1&type=client").build()
        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                Log.d("WebSocket", "Conectado!")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.d("WebSocket", "Mensaje recibido: $text")
                try {
                    val json = JSONObject(text)
                    val lat = json.getDouble("lat")
                    val lng = json.getDouble("lng")
                    _locationFlow.value = Pair(lat, lng)
                } catch (e: Exception) {
                    Log.e("WebSocket", "Error al procesar JSON: ${e.message}")
                }
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                Log.e("WebSocket", "Error WebSocket: ${t.message}")
            }
        })
    }

    fun disconnectWebSocket() {
        webSocket?.close(1000, "Cerrando conexión")
    }
}

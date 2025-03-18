package com.example.sgprepartidor.Home.Delivery.domain.services

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.sgprepartidor.Home.Delivery.data.model.LocationDTO
import com.example.sgprepartidor.Home.Delivery.data.repository.LocationWebsocketRepository
import com.example.sgprepartidor.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import java.sql.Timestamp

class LocationService() : Service() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    private val locationUpdateInterval: Long = 1000

    private var locationWebsocket : LocationWebsocketRepository? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        fusedLocationClient.removeLocationUpdates(locationCallback)
        locationWebsocket?.closeConnection()
    }

    private fun requestLocationUpdates() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(locationRequest, ContextCompat.getMainExecutor(this), locationCallback)
        } else {
            Toast.makeText(this, "Permiso de ubicación no concedido", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate() {
        super.onCreate()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, locationUpdateInterval)
            .setMinUpdateIntervalMillis(2000)
            .build()

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                locationResult.let {
                    val location = it.lastLocation
                    if (location != null) {
                        Log.d("LOCATION", location.toString())
                        locationWebsocket?.sendLocation(LocationDTO(
                            lat = location.latitude,
                            lng = location.longitude,
                            timestamp = Timestamp(location.time)
                        ))
                    }
                }
            }
        }

        locationWebsocket = LocationWebsocketRepository("ws://3.226.75.51/ws?order_id=1&type=driver")
        locationWebsocket?.connect()
        startForegroundService()
    }

    private fun createNotification(): Notification {
        val channelId = "LocationServiceChannel"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Location Service", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("Pedido en reparto")
            .setContentText("Se esta monitoreando tu ubicacion para que el cliente pueda monitorear su pedido")
            .setSmallIcon(android.R.drawable.ic_menu_mylocation)
            .build()
    }

    private fun startForegroundService() {
        val channelId = "location_service"
        val channelName = "Location Service"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_LOW
            )
            getSystemService(NotificationManager::class.java)?.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Servicio de Ubicación")
            .setContentText("Enviando ubicación en segundo plano...")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        startForeground(1, notification)

        requestLocationUpdates()
    }

//     fun setLocationListener(onLocationChange: (Location) -> Unit): Boolean {
//
//        if (ActivityCompat.checkSelfPermission(
//                context, Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            fusedLocationClient.lastLocation.addOnSuccessListener(onLocationChange)
//            return true
//        } else {
//            return false
//        }
//    }

}
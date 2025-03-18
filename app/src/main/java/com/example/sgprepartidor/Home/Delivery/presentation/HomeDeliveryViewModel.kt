package com.example.sgprepartidor.Home.Delivery.presentation

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.Home.Delivery.data.model.UpdateStatusDTO
import com.example.sgprepartidor.Home.Delivery.domain.GetCurrentDeliveryOrderUseCase
import com.example.sgprepartidor.Home.Delivery.domain.InsertDeliveryCompletedUseCase
import com.example.sgprepartidor.Home.Delivery.domain.MarkDeliveryOrderAsCompletedUseCase
import com.example.sgprepartidor.Home.Delivery.domain.services.LocationService
import com.example.sgprepartidor.Login.data.model.Delivery
import com.example.sgprepartidor.core.data.local.deliverysCompleted.entities.DeliveryCompletedEntity
import com.example.sgprepartidor.core.storage.StorageManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.time.Instant
import java.util.Date

class HomeDeliveryViewModel(
    private val deliveryStorage: StorageManager<Delivery>,
    private val context: Context,
    private val navigateDeliverysOrdersCompleted: () -> Unit
) : ViewModel() {

    private val getCurrentDeliveryOrderUseCase = GetCurrentDeliveryOrderUseCase()
    private val markDeliveryOrderUseCase = MarkDeliveryOrderAsCompletedUseCase()
    private val insertDeliveryCompletedUseCase = InsertDeliveryCompletedUseCase(context)

    private val _deliveryOrder = MutableLiveData<List<DeliveryOrder>>()

    val deliveryOrder: LiveData<List<DeliveryOrder>> = _deliveryOrder

    fun navigateToDeliverysRecord() {
        navigateDeliverysOrdersCompleted()
    }

    suspend fun getCurrentDeliveryOrder() {
        val delivery = deliveryStorage.getObjectInStorage()
        val result = getCurrentDeliveryOrderUseCase(delivery.id)

        result.onSuccess {
            data ->
            _deliveryOrder.value = data.data
        }
    }

    suspend fun markDeliveryOrderAsCompleted(deliveryOrderId: String, updateStatusDTO: UpdateStatusDTO) {
        val result = markDeliveryOrderUseCase(deliveryOrderId, updateStatusDTO)
        result.onSuccess {

            insertDeliveryCompletedUseCase(DeliveryCompletedEntity(
                date = System.currentTimeMillis(),
                supplierName = deliveryOrderId,
                productName = deliveryOrderId,
                clientName = deliveryOrderId
            ))
        }
    }


    fun startListeningLocation () {
        ContextCompat.startForegroundService(context, Intent(context, LocationService::class.java))
    }




}
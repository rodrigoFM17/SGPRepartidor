package com.example.sgprepartidor.Home.Delivery.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.Home.Delivery.data.model.UpdateStatusDTO
import com.example.sgprepartidor.Home.Delivery.domain.GetCurrentDeliveryOrderUseCase
import com.example.sgprepartidor.Home.Delivery.domain.MarkDeliveryOrderAsCompletedUseCase

class HomeDeliveryViewModel : ViewModel() {

    private val getCurrentDeliveryOrderUseCase = GetCurrentDeliveryOrderUseCase()
    private val markDeliveryOrderUseCase = MarkDeliveryOrderAsCompletedUseCase()

    private val _deliveryOrder = MutableLiveData<DeliveryOrder>()

    val deliveryOrder: LiveData<DeliveryOrder> = _deliveryOrder

    suspend fun getCurrentDeliveryOrder(deliveryId: String) {
        val result = getCurrentDeliveryOrderUseCase(deliveryId)

        result.onSuccess {
            data ->
            _deliveryOrder.value = data.data
        }
    }

    suspend fun markDeliveryOrderAsCompleted(deliveryOrderId: String, updateStatusDTO: UpdateStatusDTO) {
        val result = markDeliveryOrderUseCase(deliveryOrderId, updateStatusDTO)
        result.onSuccess {

        }

    }


}
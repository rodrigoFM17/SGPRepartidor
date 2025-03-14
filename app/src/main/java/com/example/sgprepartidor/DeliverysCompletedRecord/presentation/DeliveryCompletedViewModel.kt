package com.example.sgprepartidor.DeliverysCompletedRecord.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.DeliverysCompletedRecord.domain.GetAllDeliverysCompletedUseCase
import com.example.sgprepartidor.core.data.local.deliverysCompleted.entities.DeliveryCompletedEntity

class DeliveryCompletedViewModel(context: Context) : ViewModel() {

    private val getAllDeliverysCompletedUseCase = GetAllDeliverysCompletedUseCase(context)
    private val _deliverysCompleted = MutableLiveData<List<DeliveryCompletedEntity>>()
    val deliverysCompleted: LiveData<List<DeliveryCompletedEntity>> = _deliverysCompleted

    suspend fun getAllDeliverysCompleted () : List<DeliveryCompletedEntity> {
        return getAllDeliverysCompletedUseCase()
    }
}
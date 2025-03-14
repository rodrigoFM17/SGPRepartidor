package com.example.sgprepartidor.DeliverysOrderedRecord.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.DeliverysOrderedRecord.domain.GetAllDeliverysOrderedUseCase
import com.example.sgprepartidor.SupplierProducts.domain.InsertDeliveryOrderedUseCase
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity

class DeliverysOrderedRecordViewModel(context: Context) : ViewModel() {

    val getAllDeliverysOrderedUseCase = GetAllDeliverysOrderedUseCase(context)

    private val _deliverysOrderedRecord = MutableLiveData<List<DeliveryOrderedEntity>>()
    val deliverysOrdered : LiveData<List<DeliveryOrderedEntity>> = _deliverysOrderedRecord

    suspend fun getAllDeliverys() {
        _deliverysOrderedRecord.value = getAllDeliverysOrderedUseCase()
    }

}
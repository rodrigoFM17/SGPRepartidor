package com.example.sgprepartidor.DeliverysOrderedRecord.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.sgprepartidor.layouts.Container
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@Composable
fun DeliveryOrderedScreen(deliverysOrderedRecordViewModel: DeliverysOrderedRecordViewModel) {

    val deliverysOrdered by deliverysOrderedRecordViewModel.deliverysOrdered.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        deliverysOrderedRecordViewModel.viewModelScope.launch {
            deliverysOrderedRecordViewModel.getAllDeliverys()
        }
    }

    Container(
        headerTitle = "Historial de tus Pedidos"
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(deliverysOrdered) {
                index, deliveryOrdered -> DeliveryOrderedRow(
                    deliveryOrdered,
                    if ( index % 2 == 0 ) Color.Gray else Color.White
                )
            }
        }

    }
}

@Composable
fun DeliveryOrderedRow(deliveryOrdered: DeliveryOrderedEntity, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color)
    ) {
        Text( text = deliveryOrdered.date.toString(), modifier = Modifier.weight(1f))
        Text( text = deliveryOrdered.productName, modifier = Modifier.weight(1f))
        Text( text = deliveryOrdered.supplierName, modifier = Modifier.weight(1f))
    }
}
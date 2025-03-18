package com.example.sgprepartidor.DeliverysCompletedRecord.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sgprepartidor.DeliverysOrderedRecord.presentation.DeliveryOrderedRow
import com.example.sgprepartidor.core.data.local.deliverysCompleted.entities.DeliveryCompletedEntity
import com.example.sgprepartidor.layouts.Container

@Composable
fun DeliverysCompletedScreen (deliveryCompletedViewModel: DeliveryCompletedViewModel) {

    val deliverysCompleted by deliveryCompletedViewModel.deliverysCompleted.observeAsState(emptyList())

    Container(
        headerTitle = "historial de pedidos entregados"
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text( text = "Fecha", modifier = Modifier.weight(1f))
            Text( text = "Producto", modifier = Modifier.weight(1f))
            Text( text = "Cliente", modifier = Modifier.weight(1f))
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {

            itemsIndexed(deliverysCompleted) {
                    index, deliveryCompleted -> DeliveryCompletedRow(
                deliveryCompleted,
                if ( index % 2 == 0 ) Color.Gray else Color.White
            )
            }
        }

        
    }
}

@Composable
fun DeliveryCompletedRow(deliveryCompleted: DeliveryCompletedEntity, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color)
    ) {
        Text( text = deliveryCompleted.date.toString(), modifier = Modifier.weight(1f))
        Text( text = deliveryCompleted.productName, modifier = Modifier.weight(1f))
        Text( text = deliveryCompleted.clientName, modifier = Modifier.weight(1f))
    }

}
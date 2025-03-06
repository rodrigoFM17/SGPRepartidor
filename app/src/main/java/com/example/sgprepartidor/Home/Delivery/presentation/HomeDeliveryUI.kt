package com.example.sgprepartidor.Home.Delivery.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.layouts.Container

@Composable
fun HomeDeliveryScreen(homeDeliveryViewModel: HomeDeliveryViewModel) {

    val deliveryOrder by homeDeliveryViewModel.deliveryOrder.observeAsState(null)

    Container(
        headerTitle = "Ordenes asignadas",
    ) {
        if(deliveryOrder != null) {
            DeliveryOrderCard(deliveryOrder!!, homeDeliveryViewModel::)
        } else {
            Text(
                text = "Aun no tienes un pedido asignado",
                color = Color(0xFF7AB317),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
                )
        }
    }
}

@Composable
fun DeliveryOrderCard (deliveryOrder: DeliveryOrder, onClick: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF353535))
            .padding(20.dp),
    ) {
        Text( text = deliveryOrder.address)
        Spacer(modifier = Modifier.height(20.dp))
        Text( text = "para: ${deliveryOrder.clientName}")
        Spacer(modifier = Modifier.height(20.dp))
        Text( text = "de: ${deliveryOrder.supplierName}")
        Spacer(modifier = Modifier.height(20.dp))
        Text( text = "${deliveryOrder.deliveryProducts.size} productos")
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onClick
        ) { }
    }
}
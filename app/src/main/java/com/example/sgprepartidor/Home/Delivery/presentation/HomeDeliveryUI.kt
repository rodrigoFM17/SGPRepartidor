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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.Home.Delivery.data.model.UpdateStatusDTO
import com.example.sgprepartidor.layouts.Container
import kotlinx.coroutines.launch

@Composable
fun HomeDeliveryScreen(homeDeliveryViewModel: HomeDeliveryViewModel) {

    val deliveryOrders by homeDeliveryViewModel.deliveryOrder.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        homeDeliveryViewModel.viewModelScope.launch {
            homeDeliveryViewModel.getCurrentDeliveryOrder()
        }
    }

    Container(
        headerTitle = "Ordenes asignadas",
    ) {
        LazyColumn {
            items(deliveryOrders) {
                deliveryOrder ->
                DeliveryOrderCard(deliveryOrder)
            }
        }

    }
}

@Composable
fun DeliveryOrderCard (deliveryOrder: DeliveryOrder) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF353535))
            .padding(20.dp),
    ) {
        Text( text = "id proveedor: ${deliveryOrder.supplierId}", fontSize = 30.sp, color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
        Text( text = "id cliente ${deliveryOrder.clientId}", fontSize = 30.sp, color = Color.White)
    }
    Spacer(modifier = Modifier.height(20.dp))
}
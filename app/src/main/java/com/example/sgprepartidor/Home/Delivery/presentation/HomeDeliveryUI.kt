package com.example.sgprepartidor.Home.Delivery.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewModelScope
import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.Home.Delivery.data.model.UpdateStatusDTO
import com.example.sgprepartidor.components.ButtonComponent
import com.example.sgprepartidor.layouts.Container
import kotlinx.coroutines.launch

@Composable
fun HomeDeliveryScreen(homeDeliveryViewModel: HomeDeliveryViewModel) {

    val context = LocalContext.current
    val locationPermission = remember { mutableStateOf(ContextCompat.checkSelfPermission(
        context, Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED) }

    val requestPermissionLauncher =
        rememberLauncherForActivityResult (
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            locationPermission.value = isGranted
            if (isGranted) {
                locationPermission.value = true
            } else {
                Toast.makeText(context, "Permiso de ubicación denegado", Toast.LENGTH_SHORT).show()
            }
        }

    val deliveryOrders by homeDeliveryViewModel.deliveryOrder.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        homeDeliveryViewModel.viewModelScope.launch {
            homeDeliveryViewModel.getCurrentDeliveryOrder()
        }
    }

    Container(
        headerTitle = "Ordenes asignadas",
    ) {

        ButtonComponent(
            text = "Ver historial de ordenes completadas",
            onClick = homeDeliveryViewModel::navigateToDeliverysRecord
        )
        LazyColumn {
            items(deliveryOrders) {
                deliveryOrder ->
                DeliveryOrderCard(
                    deliveryOrder,
                    locationPermission = locationPermission.value,
                    onClick = {
                        homeDeliveryViewModel.viewModelScope.launch {
                            homeDeliveryViewModel.startListeningLocation()
                        }
                    },
                    requestPermission = requestPermissionLauncher
                )
            }
        }

    }
}

@Composable
fun DeliveryOrderCard (
    deliveryOrder: DeliveryOrder,
    locationPermission: Boolean,
    onClick: () -> Unit,
    requestPermission: ManagedActivityResultLauncher<String, Boolean>
) {
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
    Row (
        modifier = Modifier.fillMaxWidth()
    ) {
        ButtonComponent( text = "empezar la entrega" , onClick = {
            if(locationPermission) {
                onClick()
            } else {
                requestPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        })
    }
}
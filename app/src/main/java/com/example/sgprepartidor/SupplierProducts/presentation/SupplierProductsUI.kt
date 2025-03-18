package com.example.sgprepartidor.SupplierProducts.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.sgprepartidor.components.ButtonComponent
import com.example.sgprepartidor.layouts.Container
import com.example.sgprepartidor.shared.model.Product
import kotlinx.coroutines.launch

@Composable
fun SupplierProductsScreen (supplierProductsViewModel: SupplierProductsViewModel) {

    val supplier by supplierProductsViewModel.supplier.observeAsState()
    val supplierProducts by supplierProductsViewModel.supplierProducts.observeAsState(emptyList())
    val message by supplierProductsViewModel.message.observeAsState(null)

    LaunchedEffect(Unit) {
        supplierProductsViewModel.viewModelScope.launch {
            supplierProductsViewModel.getAllProductsBySupplierId()
        }
    }

    Container(
        headerTitle = "Productos de ${supplier?.name}"
    ) {

        ButtonComponent(
            text = "Ver historial de pedidos",
            onClick = supplierProductsViewModel::navigateToDeliverysRecord
        )
        message?.let { Text(text = it, color = Color.White) }

        LazyColumn {
            items(supplierProducts) {
                product -> ProductCard(product) {
                    supplierProductsViewModel.viewModelScope.launch {
                        supplierProductsViewModel.createNewDeliveryOrder(it)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onSelectProduct: (Product) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF353535))
            .padding(20.dp)
    ) {
        Text( text = product.name, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7AB317))
        Spacer(modifier = Modifier.height(10.dp))
        Text( text = "$ ${product.price}", color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))
        ButtonComponent(
            onClick = {onSelectProduct(product)},
            text = "Pedir este producto"
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}
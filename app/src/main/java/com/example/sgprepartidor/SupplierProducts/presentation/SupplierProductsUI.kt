package com.example.sgprepartidor.SupplierProducts.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sgprepartidor.SupplierProducts.data.model.Product
import com.example.sgprepartidor.layouts.Container

@Composable
fun SupplierProductsScreen (supplierProductsViewModel: SupplierProductsViewModel) {

    val supplier by supplierProductsViewModel.supplier.observeAsState()
    val supplierProducts by supplierProductsViewModel.supplierProducts.observeAsState(emptyList())

    Container(
        headerTitle = "Productos de ${supplier?.name}"
    ) {
        LazyColumn {
            items(supplierProducts) {
                product -> ProductCard(product)
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text( text = product.name)
        Spacer(modifier = Modifier.height(10.dp))
        Text( text = product.price.toString())
        Spacer(modifier = Modifier.height(10.dp))
    }
}
package com.example.sgprepartidor.Home.Client.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sgprepartidor.shared.model.Supplier

@Composable
fun SupplierCard(supplier: Supplier, onSelectSupplier: (Supplier) -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF353535))
            .padding(20.dp)
            .clickable {
                onSelectSupplier(supplier)
            },
    ) {
        Text( text = supplier.name, fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))
        Text( text = supplier.address, color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))
        Text( text = supplier.contactInfo, color = Color.White)
    }
    Spacer(modifier = Modifier.height(20.dp))

}
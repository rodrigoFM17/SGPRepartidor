package com.example.sgprepartidor.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sgprepartidor.R

@Composable
fun Container(
    headerTitle: String,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable () -> Unit
) {

    val logo = painterResource(R.drawable.logo)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF525252))
            .padding(vertical = 30.dp, horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image( painter = logo, contentDescription = "logo" )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = headerTitle,
            color = Color(0xFF7AB317),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            verticalArrangement = verticalArrangement,
            modifier = Modifier.fillMaxHeight()
        ) {
            content()
        }

    }
}
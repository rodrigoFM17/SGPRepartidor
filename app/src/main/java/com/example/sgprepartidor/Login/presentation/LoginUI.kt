package com.example.sgprepartidor.Login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sgprepartidor.components.TextFieldComponent
import com.example.sgprepartidor.layouts.Container
import kotlin.math.log

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {

    val email by loginViewModel.email.observeAsState("")
    val password by loginViewModel.password.observeAsState("")
    val isDelivery by loginViewModel.isDelivery.observeAsState(false)

    Container(
        headerTitle = "Inicio de Sesion",
        verticalArrangement = Arrangement.Center
    ) {
        TextFieldComponent(
            value = email,
            onValueChange = loginViewModel::onChangeEmail,
            placeholder = "Ingresa tu correo",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = password,
            onValueChange = loginViewModel::onChangePassword,
            placeholder = "Ingresa tu contraseña",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        Switch(
            checked = isDelivery,
            onCheckedChange = loginViewModel::onChangeIsDelivery
        )

    }
}
package com.example.sgprepartidor.Register.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sgprepartidor.components.TextFieldComponent
import com.example.sgprepartidor.layouts.Container

@Composable
fun RegisterScreen() {
    Container(
        headerTitle = "Registro de Usuario"
    ) {
        TextFieldComponent(
            value = email,
            onValueChange = {loginViewModel.onChangeEmail(it)},
            placeholder = "Ingresa tu correo",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = name,
            onValueChange = {loginViewModel.onChangeName(it)},
            placeholder = "Ingresa tu nombre de usuario",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = cellphone,
            onValueChange = {loginViewModel.onChangeCellphone(it)},
            placeholder = "Ingresa tu numero de celular",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = password,
            onValueChange = {loginViewModel.onChangePassword(it)},
            placeholder = "Ingresa tu contrasena",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )
    }
}
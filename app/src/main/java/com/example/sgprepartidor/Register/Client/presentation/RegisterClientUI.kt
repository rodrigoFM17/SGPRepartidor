package com.example.sgprepartidor.Register.Client.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.example.sgprepartidor.Login.Client.data.model.LoginClientDTO
import com.example.sgprepartidor.Register.Client.data.RegisterClientDTO
import com.example.sgprepartidor.components.ButtonComponent
import com.example.sgprepartidor.components.TextFieldComponent
import com.example.sgprepartidor.layouts.Container
import kotlinx.coroutines.launch

@Composable
fun RegisterClientScreen(registerClientViewModel: RegisterClientViewModel) {

    val name by registerClientViewModel.name.observeAsState("")
    val email by registerClientViewModel.email.observeAsState("")
    val address by registerClientViewModel.address.observeAsState("")
    val password by registerClientViewModel.password.observeAsState("")

    Container(
        headerTitle = "Registro de Cliente",
        verticalArrangement = Arrangement.Center
    ) {

        TextFieldComponent(
            value = name,
            onValueChange = registerClientViewModel::onChangeName,
            placeholder = "Ingresa tu nombre de usuario",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = email,
            onValueChange = registerClientViewModel::onChangeEmail,
            placeholder = "Ingresa tu correo",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = address,
            onValueChange = registerClientViewModel::onChangeAddress,
            placeholder = "Ingresa tu direccion",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = password,
            onValueChange = registerClientViewModel::onChangePassword,
            placeholder = "Ingresa tu contrasena",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        ButtonComponent(
            onClick = {
                registerClientViewModel.viewModelScope.launch {
                    registerClientViewModel.onSubmit(
                        RegisterClientDTO(
                            name = name,
                            email = email,
                            address = address,
                            password = password
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            text = "Iniciar Sesion"
        )
    }
}
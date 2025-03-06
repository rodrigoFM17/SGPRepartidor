package com.example.sgprepartidor.Register.Delivery.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.example.sgprepartidor.Register.Delivery.data.model.RegisterDeliveryDTO
import com.example.sgprepartidor.components.ButtonComponent
import com.example.sgprepartidor.components.TextFieldComponent
import com.example.sgprepartidor.layouts.Container
import kotlinx.coroutines.launch

@Composable
fun RegisterDeliveryScreen(registerDeliveryViewModel: RegisterDeliveryViewModel) {

    val firstName by registerDeliveryViewModel.firstName.observeAsState("")
    val lastName by registerDeliveryViewModel.lastName.observeAsState("")
    val driverId by registerDeliveryViewModel.driverId.observeAsState("")
    val email by registerDeliveryViewModel.email.observeAsState("")
    val password by registerDeliveryViewModel.password.observeAsState("")
    val failure by registerDeliveryViewModel.failure.observeAsState(false)

    Container(
        headerTitle = "Registro de Repartidor",
        verticalArrangement = Arrangement.Center
    ) {

        TextFieldComponent(
            value = firstName,
            onValueChange = registerDeliveryViewModel::onChangeFirstName,
            placeholder = "Ingresa tu nombre",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = lastName,
            onValueChange = registerDeliveryViewModel::onChangeLastName,
            placeholder = "Ingresa tus apellidos",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = driverId,
            onValueChange = registerDeliveryViewModel::onChangeDriverId,
            placeholder = "Ingresa el numero de tu licencia de conducir",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = email,
            onValueChange = registerDeliveryViewModel::onChangeEmail,
            placeholder = "Ingresa tu correo",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 30.dp
        )

        TextFieldComponent(
            value = password,
            onValueChange = registerDeliveryViewModel::onChangePassword,
            placeholder = "Ingresa tu contraseña",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 10.dp
        )

        if(failure){
            Text( text = "Hubo un error al intentar registrarte, intenta mas tarde")
        }

        ButtonComponent(
            onClick = { registerDeliveryViewModel.viewModelScope.launch {
                registerDeliveryViewModel.onSubmit(RegisterDeliveryDTO(
                    firstName = firstName,
                    lastName = lastName,
                    driverId = driverId,
                    email = email,
                    password = password
                ))
            }},
            text = "Registrarse",
            modifier = Modifier.fillMaxWidth()
        )



    }

}
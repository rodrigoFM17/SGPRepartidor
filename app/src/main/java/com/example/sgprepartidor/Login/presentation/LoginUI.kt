package com.example.sgprepartidor.Login.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.example.sgprepartidor.Login.data.model.LoginDTO
import com.example.sgprepartidor.components.ButtonComponent
import com.example.sgprepartidor.components.TextFieldComponent
import com.example.sgprepartidor.layouts.Container
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {

    val email by loginViewModel.email.observeAsState("")
    val password by loginViewModel.password.observeAsState("")
    val isDelivery by loginViewModel.isDelivery.observeAsState(false)
    val failure by loginViewModel.failure.observeAsState(false)

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

        Text(
            text = "¿Aun no tienes cuenta?",
            modifier = Modifier.clickable {
                loginViewModel.navigateRegisterClient()
            })

        TextFieldComponent(
            value = password,
            onValueChange = loginViewModel::onChangePassword,
            placeholder = "Ingresa tu contraseña",
            modifier = Modifier.fillMaxWidth(),
            spacerHeight = 10.dp
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = isDelivery,
                onCheckedChange = loginViewModel::onChangeIsDelivery
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text( text = "Inicio de sesion de repartidor", color = Color.White, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "¿Quieres ser repartidor?",
            color = Color(0xFF3C3C3C),
            modifier = Modifier.clickable {
                loginViewModel.navigateRegisterDelivery()
            }
        )

        if(failure){
            Spacer(modifier = Modifier.height(10.dp))
            Text( text = "Hubo un error al intentar iniciar sesion, intenta mas tarde", color = Color(0xFF3C3C3C))
        }

        Spacer(modifier = Modifier.height(20.dp))

        ButtonComponent(
            onClick = {
                loginViewModel.viewModelScope.launch {
                    loginViewModel.onSubmit(
                        LoginDTO(
                        email = email,
                        password = password,
                        ),
                        isDelivery
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            text = "Iniciar Sesion"
        )

    }
}
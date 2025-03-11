package com.example.sgprepartidor.Login.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Login.data.model.LoginDTO
import com.example.sgprepartidor.Login.domain.LoginClientUseCase
import com.example.sgprepartidor.Login.domain.LoginDeliveryUseCase

class LoginViewModel(
    navigateRegisterClient: () -> Unit,
    navigateRegisterDelivery: () -> Unit,
    private val navigateToClientHome: () -> Unit,
    private val navigateToDeliveryHome: () -> Unit
) : ViewModel() {

    private val loginClientUseCase = LoginClientUseCase()
    private val loginDeliveryUseCase = LoginDeliveryUseCase()

    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _isDelivery = MutableLiveData<Boolean>()
    private val _failure = MutableLiveData<Boolean>()

    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val isDelivery: LiveData<Boolean> = _isDelivery
    val failure: LiveData<Boolean> = _failure

    val navigateRegisterClient = navigateRegisterClient
    val navigateRegisterDelivery: () -> Unit = navigateRegisterDelivery

    fun onChangeEmail(email: String) {
        _email.value = email
    }

    fun onChangePassword(password: String) {
        _password.value = password
    }

    fun onChangeIsDelivery(isDelivery: Boolean) {
        _isDelivery.value = isDelivery
    }


    suspend fun onSubmit(loginDTO: LoginDTO, isDelivery: Boolean) {
        if(isDelivery){
            val result = loginDeliveryUseCase(loginDTO)
            result.onSuccess{
                navigateToDeliveryHome()
            }
        } else {
            val result = loginClientUseCase(loginDTO)
            result.onSuccess {
                navigateToClientHome()
            }
            Log.d("API", result.toString())
        }


    }
}
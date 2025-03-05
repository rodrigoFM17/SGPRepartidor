package com.example.sgprepartidor.Login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _isDelivery = MutableLiveData<Boolean>()

    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val isDelivery: LiveData<Boolean> = _isDelivery

    fun onChangeEmail(email: String) {
        _email.value = email
    }

    fun onChangePassword(password: String) {
        _password.value = password
    }

    fun onChangeIsDelivery(isDelivery: Boolean) {
        _isDelivery.value = isDelivery
    }

    suspend fun onSubmit() {

    }
}
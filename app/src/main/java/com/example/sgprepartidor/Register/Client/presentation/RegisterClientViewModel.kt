package com.example.sgprepartidor.Register.Client.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Register.Client.data.RegisterClientDTO

class RegisterClientViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    private val _address = MutableLiveData<String>()
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()

    val name: LiveData<String> = _name
    val address: LiveData<String> = _address
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password

    fun onChangeName(name: String) {
        _name.value = name
    }

    fun onChangeAddress(address: String) {
        _address.value = address
    }

    fun onChangeEmail(email: String) {
        _email.value = email
    }

    fun onChangePassword(password: String) {
        _password.value = password
    }

    suspend fun onSubmit(registerClientDTO: RegisterClientDTO) {

    }
}
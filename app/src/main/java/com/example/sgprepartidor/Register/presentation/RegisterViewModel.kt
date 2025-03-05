package com.example.sgprepartidor.Register.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Login.Client.data.model.LoginClientDTO

class RegisterViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    private val _name = MutableLiveData<String>()
    private val _cellphone = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()

    var email: LiveData<String> = _email
    val name: LiveData<String> = _name
    val cellphone: LiveData<String> =_cellphone
    val password: LiveData<String> = _password

    fun onChangeEmail(email: String) {
        _email.value = email
    }

    fun onChangeName(name: String) {
        _name.value = name
    }

    fun onChangeCellphone(cellphone: String) {
        _cellphone.value = cellphone
    }

    fun onChangePassword(password: String) {
        _password.value = password
    }

    suspend fun onSubmit(loginClientDTO: LoginClientDTO) {

    }
}
package com.example.sgprepartidor.Register.Client.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Register.Client.data.model.RegisterClientDTO
import com.example.sgprepartidor.Register.Client.domain.RegisterClientUseCase

class RegisterClientViewModel(private val navigateToLogin: () -> Unit) : ViewModel() {

    private val registerClientUseCase = RegisterClientUseCase()

    private val _name = MutableLiveData<String>()
    private val _address = MutableLiveData<String>()
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _failure = MutableLiveData<Boolean>()

    val name: LiveData<String> = _name
    val address: LiveData<String> = _address
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val failure: LiveData<Boolean> = _failure

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
        val result = registerClientUseCase(registerClientDTO)
        result.onSuccess {
            navigateToLogin()
        }

        result.onFailure {
            _failure.value = true
        }
    }
}
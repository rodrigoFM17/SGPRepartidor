package com.example.sgprepartidor.Register.Delivery.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Register.Delivery.data.model.RegisterDeliveryDTO

class RegisterDeliveryViewModel : ViewModel() {

    private val _firstName = MutableLiveData<String>()
    private val _lastName = MutableLiveData<String>()
    private val _driverId = MutableLiveData<String>()
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()

    val firstName: LiveData<String> = _firstName
    val lastName: LiveData<String> = _lastName
    val driverId: LiveData<String> = _driverId
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password

    fun onChangeFirstName(firstName: String) {
        _firstName.value = firstName
    }

    fun onChangeLastName(lastName: String) {
        _lastName.value = lastName
    }

    fun onChangeDriverId(driverId: String) {
        _driverId.value = driverId
    }

    fun onChangeEmail(email: String) {
        _email.value = email
    }

    fun onChangePassword(password: String) {
        _password.value = password
    }

    suspend fun onSubmit(registerDeliveryDTO: RegisterDeliveryDTO) {

    }

}
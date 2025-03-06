package com.example.sgprepartidor.Register.Delivery.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sgprepartidor.Register.Delivery.data.model.RegisterDeliveryDTO
import com.example.sgprepartidor.Register.Delivery.domain.RegisterDeliveryUseCase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.launch

class RegisterDeliveryViewModel(private val navigateToLogin: () -> Unit) : ViewModel() {

    val registerDeliveryUseCase = RegisterDeliveryUseCase()

    private val _firstName = MutableLiveData<String>()
    private val _lastName = MutableLiveData<String>()
    private val _driverId = MutableLiveData<String>()
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()

    private val _failure = MutableLiveData<Boolean>()

    val firstName: LiveData<String> = _firstName
    val lastName: LiveData<String> = _lastName
    val driverId: LiveData<String> = _driverId
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val failure: LiveData<Boolean> = _failure

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

    fun callToApi (registerDeliveryDTO: RegisterDeliveryDTO) {
        viewModelScope.launch {
            val result = registerDeliveryUseCase(registerDeliveryDTO)

            result.onSuccess {
            navigateToLogin()
        }

        result.onFailure {
            _failure.value = true
        }
    }
}

fun onSubmit(
    firstName: String,
    lastName: String,
    driverId: String,
    email: String,
    password: String
) {

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            task ->
            if(task.isSuccessful) {
                val token = task.result
                Log.d("Token", token)
                callToApi(RegisterDeliveryDTO(name = firstName, email = email, password = password, fcm_token = token))
            }
        }



    }

}
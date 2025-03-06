package com.example.sgprepartidor.Home.Client.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Home.Client.data.model.Supplier
import com.example.sgprepartidor.Home.Client.domain.GetAllSuppliersUseCase

class HomeClientViewModel : ViewModel() {

    private val getAllSuppliersUseCase = GetAllSuppliersUseCase()
    private val _suppliers = MutableLiveData<List<Supplier>>()
    private val _failure = MutableLiveData<Boolean>()

    val failure: LiveData<Boolean> = _failure
    val suppliers: LiveData<List<Supplier>> = _suppliers

    suspend fun getAllSuppliers () {
        val result = getAllSuppliersUseCase()
        result.onSuccess {
            data ->
            _suppliers.value = data.data
        }

        result.onFailure {
            _failure.value = true
        }
    }

    suspend fun onSelectSupplier (supplierId: String) {

    }


}
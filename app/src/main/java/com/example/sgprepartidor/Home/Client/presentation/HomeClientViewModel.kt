package com.example.sgprepartidor.Home.Client.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Home.Client.domain.GetAllSuppliersUseCase
import com.example.sgprepartidor.core.storage.StorageManager
import com.example.sgprepartidor.shared.model.Supplier

class HomeClientViewModel(
    private val navigateToSupplierProducts: () -> Unit,
    private val supplierStorage: StorageManager<Supplier>
) : ViewModel() {

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

    fun onSelectSupplier (supplier: Supplier) {
        supplierStorage.saveInStorage(supplier)
        navigateToSupplierProducts()
    }


}
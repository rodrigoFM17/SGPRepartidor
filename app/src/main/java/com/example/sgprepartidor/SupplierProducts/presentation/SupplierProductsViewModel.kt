package com.example.sgprepartidor.SupplierProducts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.SupplierProducts.domain.GetAllProductsBySupplierIdUseCase
import com.example.sgprepartidor.core.storage.StorageManager
import com.example.sgprepartidor.model.Product
import com.example.sgprepartidor.model.Supplier

class SupplierProductsViewModel(private val supplierStorage: StorageManager<Supplier>) : ViewModel() {

    private val getAllProductsBySupplierIdUseCase = GetAllProductsBySupplierIdUseCase()

    private val _supplier = MutableLiveData<Supplier>()
    val supplier: LiveData<Supplier> = _supplier

    private val _supplierProducts = MutableLiveData<List<Product>>()
    val supplierProducts: LiveData<List<Product>> = _supplierProducts

    private val _failure = MutableLiveData<Boolean>()
    val failure: LiveData<Boolean> = _failure

    suspend fun getAllProductsBySupplierId() {
        val supplier = supplierStorage.getObjectInStorage()
        val result = getAllProductsBySupplierIdUseCase(supplier.id)

        result.onSuccess {
            data ->
            _supplierProducts.value = data.data
        }

        result.onFailure {

        }

    }

    suspend fun createNewDeliveryOrder() {

    }
}
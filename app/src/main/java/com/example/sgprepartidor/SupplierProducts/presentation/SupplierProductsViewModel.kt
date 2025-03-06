package com.example.sgprepartidor.SupplierProducts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.SupplierProducts.data.model.Product
import com.example.sgprepartidor.SupplierProducts.data.model.Supplier

class SupplierProductsViewModel : ViewModel() {

    private val _supplier = MutableLiveData<Supplier>()
    val supplier: LiveData<Supplier> = _supplier

    private val _supplierProducts = MutableLiveData<List<Product>>()
    val supplierProducts: LiveData<List<Product>> = _supplierProducts

    private

    suspend fun getAllProductBySupplierId(supplierId: String) {

    }

    suspend fun createNewDeliveryOrder() {

    }
}
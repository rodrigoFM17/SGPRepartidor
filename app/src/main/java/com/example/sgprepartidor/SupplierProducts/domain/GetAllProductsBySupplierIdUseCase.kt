package com.example.sgprepartidor.SupplierProducts.domain

import com.example.sgprepartidor.SupplierProducts.data.repository.SupplierRepository
import com.example.sgprepartidor.core.network.model.APIResponse
import com.example.sgprepartidor.model.Product

class GetAllProductsBySupplierIdUseCase {

    val repository = SupplierRepository()
    suspend operator fun invoke (supplierId: String): Result<APIResponse<Product>> {
        val result = repository.getAllProductsBySupplierId(supplierId)
        return result
    }
}
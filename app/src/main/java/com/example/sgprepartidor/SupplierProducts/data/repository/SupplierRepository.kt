package com.example.sgprepartidor.SupplierProducts.data.repository

import com.example.sgprepartidor.SupplierProducts.data.model.Product
import com.example.sgprepartidor.core.network.RetrofitHelper
import com.example.sgprepartidor.core.network.model.APIResponse

class SupplierRepository {

    val supplierService = RetrofitHelper.supplierService

    suspend fun getAllProductsBySupplierId(supplierId: String): Result<APIResponse<Product>> {
        return try {
            val response = supplierService.getAllProductsBySupplierId(supplierId)
            if(response.isSuccessful){
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
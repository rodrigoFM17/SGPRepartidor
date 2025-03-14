package com.example.sgprepartidor.SupplierProducts.data.repository

import com.example.sgprepartidor.SupplierProducts.data.model.DeliveryDTO
import com.example.sgprepartidor.SupplierProducts.data.model.NewDeliveryDTO
import com.example.sgprepartidor.core.network.RetrofitHelper
import com.example.sgprepartidor.core.network.model.APIResponse
import com.example.sgprepartidor.shared.model.Product

class SupplierRepository {

    val supplierService = RetrofitHelper.supplierService

    suspend fun getAllProductsBySupplierId(supplierId: String): Result<APIResponse<List<Product>>> {
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

    suspend fun createNewDelivery(newDeliveryDTO: NewDeliveryDTO): Result<APIResponse<DeliveryDTO>> {
        return try {
            val response = supplierService.createNewDelivery(newDeliveryDTO)
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
package com.example.sgprepartidor.Home.Delivery.data.repository

import com.example.sgprepartidor.Home.Delivery.data.model.DeliveryOrder
import com.example.sgprepartidor.Home.Delivery.data.model.UpdateStatusDTO
import com.example.sgprepartidor.core.network.RetrofitHelper
import com.example.sgprepartidor.core.network.model.APIResponse

class HomeDeliveryRepository {
    private val homeDeliveryService = RetrofitHelper.homeDeliveryService

    suspend fun getCurrentDeliveryOrder (deliveryId: String): Result<APIResponse<List<DeliveryOrder>>> {
        return try {
            val response = homeDeliveryService.getCurrentDeliveryOrder(deliveryId)

            if(response.isSuccessful){
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun markDeliveryOrderAsCompleted(deliveryId: String, updateStatusDTO: UpdateStatusDTO): Result<APIResponse<Boolean>> {
        return try {
            val response = homeDeliveryService.updateStatusDeliveryOrder(deliveryId, updateStatusDTO)

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
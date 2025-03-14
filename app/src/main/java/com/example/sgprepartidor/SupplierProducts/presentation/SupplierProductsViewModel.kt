package com.example.sgprepartidor.SupplierProducts.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sgprepartidor.Login.data.model.Client
import com.example.sgprepartidor.SupplierProducts.data.model.NewDeliveryDTO
import com.example.sgprepartidor.SupplierProducts.domain.CreateNewDeliveryUseCase
import com.example.sgprepartidor.SupplierProducts.domain.GetAllProductsBySupplierIdUseCase
import com.example.sgprepartidor.SupplierProducts.domain.InsertDeliveryOrderedUseCase
import com.example.sgprepartidor.core.data.local.deliverysOrdered.entities.DeliveryOrderedEntity
import com.example.sgprepartidor.core.storage.StorageManager
import com.example.sgprepartidor.shared.model.Product
import com.example.sgprepartidor.shared.model.Supplier
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SupplierProductsViewModel(private val supplierStorage: StorageManager<Supplier>, private val clientStorage: StorageManager<Client>, context: Context) : ViewModel() {

    private val getAllProductsBySupplierIdUseCase = GetAllProductsBySupplierIdUseCase()
    private val createNewDeliveryUseCase = CreateNewDeliveryUseCase()
    private val insertDeliveryOrderedUseCase = InsertDeliveryOrderedUseCase(context = context)

    private val _supplier = MutableLiveData<Supplier>()
    val supplier: LiveData<Supplier> = _supplier

    private val _supplierProducts = MutableLiveData<List<Product>>()
    val supplierProducts: LiveData<List<Product>> = _supplierProducts

    private val _failure = MutableLiveData<Boolean>()
    val failure: LiveData<Boolean> = _failure

    private val _message = MutableLiveData<String?>()
    val message: LiveData<String?> = _message

    suspend fun getAllProductsBySupplierId() {
        val supplier = supplierStorage.getObjectInStorage()
        _supplier.value = supplier
        Log.d("STORAGE", supplier.toString())
        val result = getAllProductsBySupplierIdUseCase(supplier.id)

        result.onSuccess {
            data ->
            _supplierProducts.value = data.data
        }

        result.onFailure {

        }
    }

    suspend fun createNewDeliveryOrder(product: Product) {
        val client = clientStorage.getObjectInStorage()
        val supplier = supplierStorage.getObjectInStorage()

        Log.d("CLIENT", client.toString())
        Log.d("SUPPLIER", supplier.toString())


        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 2) // Sumar un día

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = dateFormat.format(calendar.time)

        val newDeliveryDTO = NewDeliveryDTO(
            client_id = client.id.toInt(),
            status = "Pending",
            supplier_id = supplier.id.toInt(),
            delivery_date = currentDate,
            product_id = product.id.toInt()
        )
        val result = createNewDeliveryUseCase(newDeliveryDTO)
        result.onSuccess {
            _message.value = "Pedido creado con exito"
        }
        insertDeliveryOrderedUseCase(deliveryOrdered = DeliveryOrderedEntity(
            date = Date(),
            productName = product.name,
            supplierName = supplier.name
        ))
    }
}
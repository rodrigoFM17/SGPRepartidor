package com.example.sgprepartidor.core.storage

import android.content.Context
import com.google.gson.Gson

class StorageManager<T> (private val context: Context, private val storageName: String, private val objectClass: Class<T>) {
    private val sharedPreferences = context.getSharedPreferences(storageName, Context.MODE_PRIVATE)

    fun saveInStorage(objectToStorage: T) {
        sharedPreferences.edit().putString(storageName, Gson().toJson(objectToStorage)).apply()
    }

    fun getObjectInStorage(): T {
        val objectStringJson = sharedPreferences.getString(storageName, null)
        val objectStorage = Gson().fromJson<T>(objectStringJson, objectClass::class.java)
        return objectStorage
    }

}
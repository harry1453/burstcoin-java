package com.harry1453.burst.service.internal

import com.google.gson.Gson
import com.harry1453.burst.service.DeserializerService

import io.reactivex.Single

class GsonDeserializerService : DeserializerService {

    private val gson = Gson()

    override fun <T> deserializeObject(objectData: String, objectClass: Class<T>): Single<T> {
        return Single.fromCallable { gson.fromJson(objectData, objectClass) ?: throw IllegalArgumentException("Gson could not deserialize response") }
    }
}

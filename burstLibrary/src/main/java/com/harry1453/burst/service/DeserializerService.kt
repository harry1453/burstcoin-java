package com.harry1453.burst.service

import io.reactivex.Single

interface DeserializerService {
    fun <T> deserializeObject(objectData: String, objectClass: Class<T>): Single<T>
}

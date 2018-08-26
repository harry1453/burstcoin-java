package com.harry1453.burst.service

import io.reactivex.Single

interface ObjectService {
    fun <T> fetchObject(url: String, objectClass: Class<T>): Single<T>
}

package com.harry1453.burst.service.internal

import com.harry1453.burst.service.DeserializerService
import com.harry1453.burst.service.NetworkService
import com.harry1453.burst.service.ObjectService
import io.reactivex.Single

class NetworkObjectService internal constructor(private val networkService: NetworkService, private val deserializerService: DeserializerService) : ObjectService {
    override fun <T> fetchObject(url: String, objectClass: Class<T>): Single<T> {
        return networkService
                .fetchData(url)
                .flatMap { objectData -> deserializerService.deserializeObject(objectData, objectClass) }
    }
}

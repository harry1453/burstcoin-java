package com.harry1453.burst.service.internal

import com.harry1453.burst.repository.ConfigRepository
import com.harry1453.burst.service.DeserializerService
import com.harry1453.burst.service.NetworkService
import com.harry1453.burst.service.ObjectService

object BurstServiceProviders {
    @JvmStatic
    fun getBurstServiceProvider(objectService: ObjectService, configRepository: ConfigRepository): BurstServiceProvider = BurstServiceProvider(objectService, configRepository)

    @JvmStatic
    fun getBurstServiceProvider(networkService: NetworkService, configRepository: ConfigRepository): BurstServiceProvider = BurstServiceProvider(getObjectService(networkService), configRepository)

    @JvmStatic
    fun getObjectService(networkService: NetworkService): ObjectService = NetworkObjectService(networkService, GsonDeserializerService())

    @JvmStatic
    fun getObjectService(networkService: NetworkService, deserializerService: DeserializerService): ObjectService = NetworkObjectService(networkService, deserializerService)
}

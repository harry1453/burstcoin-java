package com.harry1453.burst.explorer.service

import com.harry1453.burst.explorer.repository.ConfigRepository

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

package com.harry1453.burst.explorer.service

import com.harry1453.burst.explorer.repository.ConfigRepository

class BurstServiceProvider internal constructor(objectService: ObjectService, configRepository: ConfigRepository) {
    val burstBlockchainService: BurstBlockchainService = NodeBlockchainService(configRepository, objectService)

    val burstInfoService: BurstInfoService = RepoInfoService(objectService)

    val burstNetworkService: BurstNetworkService = PoCCNetworkService(objectService)

    val burstPriceService: BurstPriceService = CMCPriceService(objectService)
}

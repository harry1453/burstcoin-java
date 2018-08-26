package com.harry1453.burst.service.internal

import com.harry1453.burst.repository.ConfigRepository
import com.harry1453.burst.service.*

class BurstServiceProvider internal constructor(objectService: ObjectService, configRepository: ConfigRepository) {
    val burstBlockchainService: BurstBlockchainService = NodeBlockchainService(configRepository, objectService)

    val burstInfoService: BurstInfoService = RepoInfoService(objectService)

    val burstNetworkService: BurstNetworkService = PoCCNetworkService(objectService)

    val burstPriceService: BurstPriceService = CMCPriceService(objectService)
}

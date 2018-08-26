package com.harry1453.burst.service

import com.harry1453.burst.entity.network.EventInfo

import io.reactivex.Single

interface BurstInfoService {
    val events: Single<List<EventInfo>>
}

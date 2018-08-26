package com.harry1453.burst.service

import com.harry1453.burst.entity.network.NetworkStatus

import io.reactivex.Single

interface BurstNetworkService {
    val networkStatus: Single<NetworkStatus>
}

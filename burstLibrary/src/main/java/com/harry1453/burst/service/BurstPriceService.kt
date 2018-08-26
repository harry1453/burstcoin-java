package com.harry1453.burst.service

import com.harry1453.burst.entity.price.BurstPrice

import io.reactivex.Single

interface BurstPriceService {
    fun fetchPrice(currencyCode: String): Single<BurstPrice>
}

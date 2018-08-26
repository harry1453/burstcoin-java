package com.harry1453.burst.service

import io.reactivex.Single

interface NetworkService {
    fun fetchData(url: String): Single<String>
}

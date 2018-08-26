package com.harry1453.burst.entity.price

import java.math.BigDecimal

data class BurstPrice (
        @JvmField val currencyCode: String,
        @JvmField val price: BigDecimal,
        @JvmField val marketCapital: BigDecimal
)
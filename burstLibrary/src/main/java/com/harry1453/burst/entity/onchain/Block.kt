package com.harry1453.burst.entity.onchain

import com.harry1453.burst.entity.general.BurstValue
import org.jetbrains.annotations.Nullable
import java.math.BigInteger

data class Block (
        @JvmField val transactionCount: Long,
        @JvmField val timestamp: BigInteger,
        @JvmField val blockID: BigInteger,
        @JvmField val total: BurstValue,
        @JvmField val size: Long,
        @JvmField val fee: BurstValue,
        @JvmField val blockReward: BurstValue,
        @JvmField val transactionIDs: List<BigInteger>,
        @JvmField val blockNumber: Long,
        @JvmField val generatorID: BigInteger,
        @Nullable @JvmField var generator: Account?
) {
    fun setGenerator(generator: Account?) {
        this.generator = generator
    }
}
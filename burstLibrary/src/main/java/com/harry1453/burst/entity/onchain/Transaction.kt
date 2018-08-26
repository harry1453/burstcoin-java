package com.harry1453.burst.entity.onchain

import com.harry1453.burst.entity.general.BurstAddress
import com.harry1453.burst.entity.general.BurstValue
import java.math.BigInteger

data class Transaction (
        @JvmField val amount: BurstValue,
        @JvmField val blockID: BigInteger,
        @JvmField val fullHash: String,
        @JvmField val confirmations: Long,
        @JvmField val fee: BurstValue,
        @JvmField val type: Int,
        @JvmField val signatureHash: String,
        @JvmField val signature: String,
        @JvmField val sender: BurstAddress,
        @JvmField val recipient: BurstAddress,
        @JvmField val timestamp: BigInteger,
        @JvmField val transactionID: BigInteger,
        // TODO Attachment
        @JvmField val subType: Int
)
package com.harry1453.burst.entity.onchain

import com.harry1453.burst.entity.general.BurstAddress
import com.harry1453.burst.entity.general.BurstValue

data class Account (
        @JvmField val address: BurstAddress,
        @JvmField val publicKey: String,
        @JvmField val name: String,
        @JvmField val description: String,
        @JvmField val balance: BurstValue,
        @JvmField val forgedBalance: BurstValue,
        // TODO issued assets
        @JvmField val rewardRecipient: BurstAddress,
        @JvmField val rewardRecipientName: String
)
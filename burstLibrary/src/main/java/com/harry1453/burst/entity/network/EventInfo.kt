package com.harry1453.burst.entity.network

import org.jetbrains.annotations.Nullable

class EventInfo(@JvmField val name: String, @Nullable infoPage: String?, @Nullable blockHeight: Long?) {
    @JvmField val infoPage: String
    @JvmField val infoPageSet: Boolean
    @JvmField val blockHeight: Long
    @JvmField val blockHeightSet: Boolean

    init {
        if (infoPage == null || infoPage == "") {
            this.infoPage = ""
            infoPageSet = false
        } else {
            this.infoPage = infoPage
            infoPageSet = true
        }

        if (blockHeight == null) {
            this.blockHeight = 0
            blockHeightSet = false
        } else {
            this.blockHeight = blockHeight
            blockHeightSet = true
        }
    }
}

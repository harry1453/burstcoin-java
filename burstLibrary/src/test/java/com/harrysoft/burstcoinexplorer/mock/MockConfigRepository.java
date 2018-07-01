package com.harrysoft.burstcoinexplorer.mock;

import com.harry1453.burst.explorer.repository.ConfigRepository;
import org.jetbrains.annotations.NotNull;

public class MockConfigRepository implements ConfigRepository {

    private String currencyCode;
    private String nodeAddress;

    public MockConfigRepository() {
        currencyCode = "USD";
        nodeAddress = "https://wallet.burst.cryptoguru.org:8125/burst";
    }

    @Override
    public void setSelectedCurrency(@NotNull String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @NotNull
    @Override
    public String getSelectedCurrency() {
        return currencyCode;
    }

    @Override
    public void setNodeAddress(@NotNull String nodeAddress) {
        this.nodeAddress = nodeAddress;
    }

    @NotNull
    @Override
    public String getNodeAddress() {
        return nodeAddress;
    }
}

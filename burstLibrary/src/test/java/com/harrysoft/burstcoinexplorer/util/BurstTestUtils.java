package com.harrysoft.burstcoinexplorer.util;

import com.harry1453.burst.explorer.service.BurstServiceProvider;
import com.harry1453.burst.explorer.service.BurstServiceProviders;
import com.harrysoft.burstcoinexplorer.mock.MockConfigRepository;
import com.harrysoft.burstcoinexplorer.mock.MockNetworkService;

public class BurstTestUtils {
    public static BurstServiceProvider getBurstServiceProvider() {
        return BurstServiceProviders.getBurstServiceProvider(BurstServiceProviders.getObjectService(new MockNetworkService()), new MockConfigRepository());
    }
}

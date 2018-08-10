package com.harry1453.burst.test.util;

import com.harry1453.burst.explorer.service.BurstServiceProvider;
import com.harry1453.burst.explorer.service.BurstServiceProviders;
import com.harry1453.burst.test.mock.MockConfigRepository;
import com.harry1453.burst.test.mock.MockNetworkService;

public class BurstTestUtils {
    public static BurstServiceProvider getBurstServiceProvider() {
        return BurstServiceProviders.getBurstServiceProvider(new MockNetworkService(), new MockConfigRepository());
    }
}

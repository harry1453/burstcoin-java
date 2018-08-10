package com.harry1453.burst.test.runner;

import com.harry1453.burst.test.test.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BurstAddressTest.class,
        BurstBlockchainServiceTest.class,
        BurstInfoServiceTest.class,
        BurstNetworkServiceTest.class,
        BurstPriceServiceTest.class,
        BurstValueTest.class,
        DetermineSearchRequestTypeTest.class,
})

public class AllUnitTests {
    // Runs all unit tests
}

package com.harry1453.burst.test.tests;

import com.harry1453.burst.entity.price.BurstPrice;
import com.harry1453.burst.service.BurstPriceService;
import com.harry1453.burst.test.util.BurstTestUtils;
import com.harry1453.burst.test.util.SingleTestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class BurstPriceServiceTest {

    private BurstPriceService burstPriceService;

    @Before
    public void setUpBurstPriceServiceTest() {
        burstPriceService = BurstTestUtils.getBurstServiceProvider().getBurstPriceService();
    }

    @Test
    public void testBurstPriceServiceFetchPrice() {
        BurstPrice price = SingleTestUtils.testSingle(burstPriceService.fetchPrice("USD"));
        assertEquals("USD", price.currencyCode);
        assertNotNull(price.price);
        assertNotNull(price.marketCapital);
    }
}

package com.harrysoft.burstcoinexplorer.test;

import com.harry1453.burst.explorer.entity.BurstPrice;
import com.harry1453.burst.explorer.service.BurstPriceService;
import com.harrysoft.burstcoinexplorer.util.BurstTestUtils;
import com.harrysoft.burstcoinexplorer.util.SingleTestUtils;

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

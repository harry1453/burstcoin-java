package com.harry1453.burst.test.tests;

import com.harry1453.burst.entity.network.EventInfo;
import com.harry1453.burst.service.BurstInfoService;
import com.harry1453.burst.test.util.BurstTestUtils;
import com.harry1453.burst.test.util.SingleTestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;

@RunWith(JUnit4.class)
public class BurstInfoServiceTest {

    private BurstInfoService burstInfoService;

    @Before
    public void setUpBurstInfoServiceTest() {
        burstInfoService = BurstTestUtils.getBurstServiceProvider().getBurstInfoService();
    }

    @Test
    public void testBurstInfoServiceTestGetEvents() {
        List<EventInfo> eventInfoArray = SingleTestUtils.testSingle(burstInfoService.getEvents());
        assertNotSame(0, eventInfoArray.size());
        for (EventInfo eventInfo : eventInfoArray) {
            assertNotNull(eventInfo);
            if (eventInfo.blockHeightSet) {
                assertNotSame(0, eventInfo.blockHeight);
            } else {
                assertEquals(0, eventInfo.blockHeight);
            }
            if (eventInfo.infoPageSet) {
                assertNotSame("", eventInfo.infoPage);
            } else {
                assertEquals("", eventInfo.infoPage);
            }
        }
    }
}

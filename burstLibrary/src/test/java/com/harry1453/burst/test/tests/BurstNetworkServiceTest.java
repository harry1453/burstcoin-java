package com.harry1453.burst.test.tests;

import com.harry1453.burst.entity.network.NetworkStatus;
import com.harry1453.burst.service.BurstNetworkService;
import com.harry1453.burst.test.util.BurstTestUtils;
import com.harry1453.burst.test.util.SingleTestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class BurstNetworkServiceTest {

    private BurstNetworkService burstNetworkService;

    @Before
    public void setUpBurstNetworkServiceTest() {
        burstNetworkService = BurstTestUtils.getBurstServiceProvider().getBurstNetworkService();
    }

    @Test
    public void testBurstNetworkServiceFetchNetworkStatus() {
        NetworkStatus networkStatus = SingleTestUtils.testSingle(burstNetworkService.getNetworkStatus());
        assertNotNull(networkStatus.blockHeight);
        assertNotNull(networkStatus.peersActiveInCountry);
        assertNotNull(networkStatus.peersData);
        assertNotNull(networkStatus.peersData.peersStatus);
        List<NetworkStatus.BrokenPeer> brokenPeerList = networkStatus.getBrokenPeersFromMap();
        assertNotNull(brokenPeerList);
        for(NetworkStatus.BrokenPeer brokenPeer : brokenPeerList) {
            assertNotNull(brokenPeer);
        }
        List<NetworkStatus.PeersData.PeerVersion> peerVersionList = networkStatus.peersData.getPeerVersionsFromMap();
        assertNotNull(peerVersionList);
        for(NetworkStatus.PeersData.PeerVersion peerVersion : peerVersionList) {
            assertNotNull(peerVersion);
        }
    }
}

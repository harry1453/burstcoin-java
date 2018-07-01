package com.harrysoft.burstcoinexplorer.test;

import com.harry1453.burst.explorer.entity.Block;
import com.harry1453.burst.explorer.service.BurstBlockchainService;
import com.harrysoft.burstcoinexplorer.TestVariables;
import com.harrysoft.burstcoinexplorer.util.BurstTestUtils;
import com.harrysoft.burstcoinexplorer.util.SingleTestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigInteger;
import java.util.List;

import static junit.framework.Assert.assertNotSame;

@RunWith(JUnit4.class)
public class BurstBlockchainServiceTest {

    private BurstBlockchainService burstBlockchainService;

    @Before
    public void setUpBurstAPIServiceTest() {
        burstBlockchainService = BurstTestUtils.getBurstServiceProvider().getBurstBlockchainService();
    }

    @Test
    public void testBurstAPIServiceFetchRecentBlocks() {
        List<Block> blocks = SingleTestUtils.testSingle(burstBlockchainService.fetchRecentBlocks());
        assertNotSame(0, blocks.size());
    }

    @Test
    public void testBurstAPIServiceFetchBlockByHeight() {
        SingleTestUtils.testSingle(burstBlockchainService.fetchBlockByHeight(new BigInteger(TestVariables.EXAMPLE_BLOCK_HEIGHT)));
    }

    @Test
    public void testBurstAPIServiceFetchBlockByID() {
        SingleTestUtils.testSingle(burstBlockchainService.fetchBlockByID(new BigInteger(TestVariables.EXAMPLE_BLOCK_ID)));
    }

    @Test
    public void testBurstAPIServiceFetchAccount() {
        SingleTestUtils.testSingle(burstBlockchainService.fetchAccount(new BigInteger(TestVariables.EXAMPLE_ACCOUNT_ID)));
    }

    @Test
    public void testBurstAPIServiceFetchAccountTransactions() {
        SingleTestUtils.testSingle(burstBlockchainService.fetchAccountTransactions(new BigInteger(TestVariables.EXAMPLE_ACCOUNT_ID)));
    }

    @Test
    public void testBurstAPIServiceFetchTransaction() {
        SingleTestUtils.testSingle(burstBlockchainService.fetchTransaction(new BigInteger(TestVariables.EXAMPLE_TRANSACTION_ID)));
    }
}

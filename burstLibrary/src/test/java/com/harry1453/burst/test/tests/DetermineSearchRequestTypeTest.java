package com.harry1453.burst.test.tests;

import com.harry1453.burst.entity.search.SearchRequestType;
import com.harry1453.burst.entity.search.SearchResult;
import com.harry1453.burst.service.BurstBlockchainService;
import com.harry1453.burst.test.TestVariables;
import com.harry1453.burst.test.util.BurstTestUtils;
import com.harry1453.burst.test.util.SingleTestUtils;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DetermineSearchRequestTypeTest {

    private BurstBlockchainService burstBlockchainService;

    @Before
    public void setUpBurstAPIServiceTest() {
        burstBlockchainService = BurstTestUtils.getBurstServiceProvider().getBurstBlockchainService();
    }

    @Test
    public void testBurstBlockchainServiceDetermineIDTypeAccountRS() {
        SearchResult result = SingleTestUtils.testSingle(burstBlockchainService.determineSearchRequestType(TestVariables.EXAMPLE_ACCOUNT_RS));
        assertEquals(SearchRequestType.ACCOUNT_RS, result.requestType);
    }

    @Test
    public void testBurstBlockchainServiceDetermineIDTypeAccountID() {
        SearchResult result = SingleTestUtils.testSingle(burstBlockchainService.determineSearchRequestType(TestVariables.EXAMPLE_ACCOUNT_ID));
        assertEquals(SearchRequestType.ACCOUNT_ID, result.requestType);
    }

    @Test
    public void testBurstBlockchainServiceDetermineIDTypeBlockHeight() {
        SearchResult result = SingleTestUtils.testSingle(burstBlockchainService.determineSearchRequestType(TestVariables.EXAMPLE_BLOCK_HEIGHT));
        assertEquals(SearchRequestType.BLOCK_NUMBER, result.requestType);
    }

    @Test
    public void testBurstBlockchainServiceDetermineIDTypeBlockID() {
        SearchResult result = SingleTestUtils.testSingle(burstBlockchainService.determineSearchRequestType(TestVariables.EXAMPLE_BLOCK_ID));
        assertEquals(SearchRequestType.BLOCK_ID, result.requestType);
    }

    @Test
    public void testBurstBlockchainServiceDetermineIDTypeTransactionID() {
        SearchResult result = SingleTestUtils.testSingle(burstBlockchainService.determineSearchRequestType(TestVariables.EXAMPLE_TRANSACTION_ID));
        assertEquals(SearchRequestType.TRANSACTION_ID, result.requestType);
    }

    @Test
    public void testBurstBlockchainServiceDetermineIDTypeInvalid() {
        SearchResult result = SingleTestUtils.testSingle(burstBlockchainService.determineSearchRequestType("Not a search term"));
        assertEquals(SearchRequestType.INVALID, result.requestType);
    }
}

package com.harry1453.burst.service

import com.harry1453.burst.entity.onchain.Account
import com.harry1453.burst.entity.onchain.Block
import com.harry1453.burst.entity.search.SearchResult
import com.harry1453.burst.entity.onchain.Transaction

import java.math.BigInteger

import io.reactivex.Single

interface BurstBlockchainService {
    fun fetchRecentBlocks(): Single<List<Block>>
    fun fetchBlockByHeight(blockHeight: BigInteger): Single<Block>
    fun fetchBlockByID(blockID: BigInteger): Single<Block>
    fun fetchAccount(accountID: BigInteger): Single<Account>
    fun fetchAccountRewardRecipient(accountID: BigInteger): Single<BigInteger>
    fun fetchAccountTransactions(accountID: BigInteger): Single<List<BigInteger>>
    fun fetchTransaction(transactionID: BigInteger): Single<Transaction>
    fun determineSearchRequestType(searchRequest: String): Single<SearchResult>
}

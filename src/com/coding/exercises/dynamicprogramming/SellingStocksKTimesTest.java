package com.coding.exercises.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellingStocksKTimesTest {
    private SellingStocksKTimes sellingStocksKTimes;
    private SellingStocksKTimesTabulation sellingStocksKTimesTabulation;

    public SellingStocksKTimesTest() {
        sellingStocksKTimes = new SellingStocksKTimes();
        sellingStocksKTimesTabulation = new SellingStocksKTimesTabulation();
    }

    @Test
    public void testSimple() {
        int k = 2;
        int[] prices = {2,4,1,4};
        int ret = sellingStocksKTimes.maxProfit(k, prices);
        Assertions.assertTrue(ret==5);
        ret = sellingStocksKTimesTabulation.maxProfit(k, prices);
        Assertions.assertTrue(ret==5);
    }

    @Test
    public void testLessTransactions() {
        int k = 2;
        int[] prices = {2,4,5};
        int ret = sellingStocksKTimes.maxProfit(k, prices);
        Assertions.assertTrue(ret==3);
        ret = sellingStocksKTimesTabulation.maxProfit(k, prices);
        Assertions.assertTrue(ret==3);
    }

    @Test
    public void testLowFinish() {
        int k = 2;
        int[] prices = {2,4,5,1};
        int ret = sellingStocksKTimes.maxProfit(k, prices);
        Assertions.assertTrue(ret==3);
        ret = sellingStocksKTimesTabulation.maxProfit(k, prices);
        Assertions.assertTrue(ret==3);
    }
}

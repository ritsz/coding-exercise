package com.coding.exercises.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SellingStocksMultipleTest {
    private SellingStocksMultiple sellingStocksMultiple;

    public SellingStocksMultipleTest() {
        this.sellingStocksMultiple = new SellingStocksMultiple();
    }

    @Test
    public void testIncreasing() {
        int[] prices = {1,2,3,4,5};
        int ret = sellingStocksMultiple.maxProfit(prices);
        Assertions.assertTrue(ret==4);
    }

    @Test
    public void testDecreasing() {
        int[] prices = {5,4,3,2,1};
        int ret = sellingStocksMultiple.maxProfit(prices);
        Assertions.assertTrue(ret==0);
    }

    @Test
    public void testSimple() {
        int[] prices = {7,1,5,3,6,4};
        int ret = sellingStocksMultiple.maxProfit(prices);
        Assertions.assertTrue(ret==7);
    }

    @Test
    public void testIncreasingEnd() {
        int[] prices = {1,5,7,5,6,11};
        int ret = sellingStocksMultiple.maxProfit(prices);
        Assertions.assertTrue(ret==12);
    }
}

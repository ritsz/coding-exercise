package com.coding.exercises.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellingStocksTwiceTest {
    private SellingStocksTwice sellingStocksTwice;
    private SellingStocksTwiceTabulation sellingStocksTwiceTabulation;

    public SellingStocksTwiceTest() {
        sellingStocksTwice = new SellingStocksTwice();
        sellingStocksTwiceTabulation = new SellingStocksTwiceTabulation();
    }

    @Test
    public void testSimple() {
        int[] prices = {3,3,5,0,0,3,1,4};
        int ret = sellingStocksTwice.maxProfit(prices);
        Assertions.assertTrue(ret==6);
        ret = sellingStocksTwiceTabulation.maxProfit(prices);
        Assertions.assertTrue(ret==6);
    }

    @Test
    public void testDisjointPeriods() {
        int[] prices = {4,10,4,5,4,5,4,10};
        int ret = sellingStocksTwice.maxProfit(prices);
        Assertions.assertTrue(ret==12);
        ret = sellingStocksTwiceTabulation.maxProfit(prices);
        Assertions.assertTrue(ret==12);
    }

    @Test
    public void testIncreasing() {
        int[] prices = {1,2,3,4,5};
        int ret = sellingStocksTwice.maxProfit(prices);
        Assertions.assertTrue(ret==4);
        ret = sellingStocksTwiceTabulation.maxProfit(prices);
        Assertions.assertTrue(ret==4);
    }

    @Test
    public void testDecreasing() {
        int[] prices = {7,6,5,4,3};
        int ret = sellingStocksTwice.maxProfit(prices);
        Assertions.assertTrue(ret==0);
        ret = sellingStocksTwiceTabulation.maxProfit(prices);
        Assertions.assertTrue(ret==0);
    }
}

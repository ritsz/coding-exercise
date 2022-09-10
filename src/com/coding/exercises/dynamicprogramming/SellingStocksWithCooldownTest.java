package com.coding.exercises.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellingStocksWithCooldownTest {

    private SellingStocksWithCooldown sellingStocksWithCooldown;
    private SellingStocksWithCooldownTabulation sellingStocksWithCooldownTabulation;

    public SellingStocksWithCooldownTest() {
        sellingStocksWithCooldown = new SellingStocksWithCooldown();
        sellingStocksWithCooldownTabulation = new SellingStocksWithCooldownTabulation();
    }

    @Test
    public void testIncreasing() {
        int[] prices = {1,2,3,4,5};
        int ret = sellingStocksWithCooldown.maxProfit(prices);
        Assertions.assertTrue(ret == 4);
        ret = sellingStocksWithCooldownTabulation.maxProfit(prices);
        Assertions.assertTrue(ret == 4);
    }

    @Test
    public void testSimple() {
        int[] prices = {1,2,3,0,2};
        int ret = sellingStocksWithCooldown.maxProfit(prices);
        Assertions.assertTrue(ret == 3);
        ret = sellingStocksWithCooldownTabulation.maxProfit(prices);
        Assertions.assertTrue(ret == 3);
    }

    @Test
    public void testDecreasing() {
        int[] prices = {5,4,3,2,1};
        int ret = sellingStocksWithCooldown.maxProfit(prices);
        Assertions.assertTrue(ret == 0);
        ret = sellingStocksWithCooldownTabulation.maxProfit(prices);
        Assertions.assertTrue(ret == 0);
    }

    @Test
    public void testSwings() {
        int[] prices = {1,2,3,4,0,3,5,0,3};
        int ret = sellingStocksWithCooldown.maxProfit(prices);
        Assertions.assertTrue(ret == 8);
        ret = sellingStocksWithCooldownTabulation.maxProfit(prices);
        Assertions.assertTrue(ret == 8);
    }

    @Test
    public void testSingle() {
        int[] prices = {100};
        int ret = sellingStocksWithCooldown.maxProfit(prices);
        Assertions.assertTrue(ret == 0);
        ret = sellingStocksWithCooldownTabulation.maxProfit(prices);
        Assertions.assertTrue(ret == 0);
    }
}

package com.coding.exercises.arrays;

import java.util.Arrays;

public class SellingStocksMultiple {
    public int maxProfit(int[] prices) {
        int totalProfit = 0, runningProfit = 0, start = 0;

        // Find profit in every increasing subsequence.
        for(int index = 1; index < prices.length; index++) {
            if (prices[index] >= prices[index-1]) {
                runningProfit = prices[index] - prices[start];
            } else {
                totalProfit += runningProfit;
                runningProfit = 0;
                start = index;
            }
        }
        totalProfit += runningProfit;

        return totalProfit;
    }
}

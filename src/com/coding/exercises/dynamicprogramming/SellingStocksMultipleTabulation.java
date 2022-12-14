package com.coding.exercises.dynamicprogramming;

import java.util.Arrays;

public class SellingStocksMultipleTabulation {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length+1];
        return maxProfitTabulation(prices, dp);
    }

    /**
     * Refer to the recursive solution which goes from 0 to N.
     * 1. Add base case for N+1.
     * 2. Iterate over choices, eg index, buy/sell, capacity.
     * 3. Take reccurance solution and change recursive call to DP[index+1][...]
     *
     * DP is getting generated from N to 0;
     * DP[0][...] will have the answer.
     */
    private int maxProfitTabulation(int[] prices, int[][] dp) {
        dp[0][prices.length] = dp[1][prices.length] = 0;
        for (int index = prices.length-1; index >=0; index --) {
            for (int buy = 0; buy <=1; buy++ ) {
                int profit = 0;
                if (buy == 1) {
                    profit = Math.max(
                        dp[0][index+1] - prices[index], // We bought today and will sell later.
                        dp[1][index+1] // We skip today and will buy later.
                    );
                } else {
                    profit = Math.max(
                        prices[index] + dp[1][index+1], // We sold today and can buy again
                        dp[0][index+1] // Skip selling today, we sell later.
                    );
                }
                dp[buy][index] = profit;
            }
        }
        return dp[1][0];  // Return the result of BUY on Day 0.
    }
}

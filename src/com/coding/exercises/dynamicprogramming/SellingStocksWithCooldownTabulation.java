package com.coding.exercises.dynamicprogramming;

import java.util.Arrays;

public class SellingStocksWithCooldownTabulation {
    public int maxProfit(int[] prices) {
        return maxProfitTabulation(prices);
    }

    private int maxProfitTabulation(int[] prices) {
        int[][] dp = new int[2][prices.length+2];
        Arrays.fill(dp[0], 0);
        Arrays.fill(dp[1], 0);

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy ++) {
                int profit = 0;
                if (buy == 1) {
                    profit = Math.max(
                        dp[0][index+1] - prices[index], // BUY now
                        dp[1][index+1] // BUY later
                    );
                } else {
                    profit = Math.max(
                        dp[1][index+2] + prices[index], // SELL now, skip a day
                        dp[0][index+1] // SELL later
                    );
                }
                dp[buy][index] = profit;
            }
        }
        return dp[1][0];  // Return profit for buying from first day.
    }
}

package com.coding.exercises.dynamicprogramming;

import java.util.Arrays;

public class SellingStocksWithCooldown {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return maxProfitSubProblem(prices, 0, 1, dp);
    }

    private int maxProfitSubProblem(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length)
            return 0;

        if (dp[buy][index] != -1)
            return dp[buy][index];

        int profit = 0;
        // Allowed to BUY. We can either buy, or skip a day and buy later.
        if (buy == 1) {
            profit = Math.max(
                maxProfitSubProblem(prices, index+1, 0, dp) - prices[index], // BUY now
                maxProfitSubProblem(prices, index+1, 1, dp) // BUY later
            );
        }
        // Allowed to SELL. We either sell and skip a day, or we sell later.
        else {
            profit = Math.max(
                maxProfitSubProblem(prices, index+2, 1, dp) + prices[index], // SELL now, Skip a day
                maxProfitSubProblem(prices, index+1, 0, dp) // SELL later
            );
        }

        dp[buy][index] = profit;
        return profit;
    }

}

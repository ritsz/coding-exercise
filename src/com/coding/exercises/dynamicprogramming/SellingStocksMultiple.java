package com.coding.exercises.dynamicprogramming;

import java.util.Arrays;

public class SellingStocksMultiple {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return maxProfitSubProblem(prices, 0, 1, dp); // Starting from index 0, buy anything
    }

    private int maxProfitSubProblem(int[] prices, int index, int buy, int[][]dp) {
        int maxProfit = 0;
        if (index == prices.length)
            return 0;

        if (dp[buy][index] != -1)
            return dp[buy][index];

        if (buy == 1) {
            maxProfit = Math.max(
                maxProfitSubProblem(prices, index+1, 0, dp) - prices[index], // We bought today and will sell later.
                maxProfitSubProblem(prices, index+1, 1, dp) // We skip today and will buy later.
            );
        } else {
            maxProfit = Math.max(
                prices[index] + maxProfitSubProblem(prices, index+1, 1, dp), // We sold today and can buy again
                maxProfitSubProblem(prices, index+1, 0, dp) // Skip selling today, we sell later.
            );
        }
        dp[buy][index] = maxProfit;
        return maxProfit;
    }

}

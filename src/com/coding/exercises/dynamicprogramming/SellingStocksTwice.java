package com.coding.exercises.dynamicprogramming;

import java.util.Arrays;

public class SellingStocksTwice {
    public int maxProfit(int[] prices) {
        int numberOfTransactions = 2;
        int[][][]dp = new int[2][numberOfTransactions+1][prices.length]; // 2 -> buy/no-buy;
        for (int i = 0; i < 2; i++) {
            for (int index = 0; index <= numberOfTransactions; index++) {
                Arrays.fill(dp[i][index], -1);
            }
        }
        return maxProfitSubProblem(prices, 0, 1, numberOfTransactions, dp);
    }

    private int maxProfitSubProblem(int[] prices, int index, int buy, int numberOfTransactions, int[][][]dp) {
        int maxProfit = 0;

        if (index == prices.length)
            return 0;

        if (dp[buy][numberOfTransactions][index] != -1)
            return dp[buy][numberOfTransactions][index];

        // If buy is allowed and numberOfTransactions is not zero, we can BUY or SKIP
        if (buy == 1 && numberOfTransactions != 0) {
            maxProfit = Math.max(
                -prices[index] + maxProfitSubProblem(prices, index+1, 0, numberOfTransactions-1, dp),
                maxProfitSubProblem(prices, index+1, 1, numberOfTransactions, dp)
            );
        }
        // If numberOfTransactions, we can only SKIP. We have already bought enough.
        else if (buy == 1 && numberOfTransactions == 0){
            maxProfit = maxProfitSubProblem(prices, index+1, 1, numberOfTransactions, dp);
        }
        // If we are allowed to sell, we can SELL or SKIP.
        else if (buy == 0) {
            maxProfit = Math.max(
                prices[index] + maxProfitSubProblem(prices, index+1, 1, numberOfTransactions, dp),
                maxProfitSubProblem(prices, index+1, 0, numberOfTransactions, dp)
            );
        }

        dp[buy][numberOfTransactions][index] = maxProfit;
        return maxProfit;
    }
}

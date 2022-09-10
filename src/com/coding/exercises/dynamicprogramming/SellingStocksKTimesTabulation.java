package com.coding.exercises.dynamicprogramming;

import java.util.Arrays;

public class SellingStocksKTimesTabulation {
    public int maxProfit(int k, int[] prices) {
        int numberOfTransactions = k;
        int[][][]dp = new int[2][numberOfTransactions+1][prices.length+1]; // 2 -> buy/no-buy;
        for (int i = 0; i < 2; i++) {
            for (int index = 0; index <= numberOfTransactions; index++) {
                Arrays.fill(dp[i][index], 0);
            }
        }
        return maxProfitTabulation(prices, dp, numberOfTransactions);
    }

    private int maxProfitTabulation(int[] prices, int[][][] dp, int maxTransactions) {
        for (int index = prices.length - 1; index >= 0; index--) {
            for (int numberOfTransactions = maxTransactions; numberOfTransactions >= 0; numberOfTransactions--) {
                for (int buy = 0; buy <= 1; buy++) {
                    int maxProfit = 0;
                    if (buy == 1 && numberOfTransactions != 0) {
                        maxProfit = Math.max(
                            -prices[index] +  dp[0][numberOfTransactions-1][index+1],  // BUY now, sell later, one transaction less
                            dp[1][numberOfTransactions][index+1] // SKIP this, buy later.
                        );
                    }
                    // If numberOfTransactions, we can only SKIP. We have already bought enough.
                    else if (buy == 1 && numberOfTransactions == 0){
                        maxProfit = 0;
                    }
                    // If we are allowed to sell, we can SELL or SKIP.
                    else if (buy == 0) {
                        maxProfit = Math.max(
                            prices[index] + dp[1][numberOfTransactions][index+1], // SELL now, buy later
                            dp[0][numberOfTransactions][index+1] // SKIP and Sell later
                        );
                    }
                    dp[buy][numberOfTransactions][index] = maxProfit;
                }
            }
        }
        return dp[1][maxTransactions][0]; // Return Buying from first day with all available transactions.
    }
}

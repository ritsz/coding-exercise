package com.coding.exercises.dynamicprogramming;

import java.util.Arrays;

public class SellingStocksWithCooldownTabulation {
    public int maxProfit(int[] prices) {
        return maxProfitTabulation(prices);
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

    /**
     * The state for index depends on index+1 and index+2.
     * We can reduce space complexity buy just recording data for the
     * coming 2 days.
     */
    public int maxProfitTabulationSpaceOptimization(int[] prices) {
        int todayBuy = 0;
        int tomorrowBuy = 0, tomorrowSell = 0;
        int dayafterBuy = 0;

        for (int index = prices.length - 1; index >= 0; index--) {
            todayBuy = Math.max(
                tomorrowSell - prices[index], // BUY now
                tomorrowBuy // BUY later
            );
            tomorrowSell = Math.max(
                dayafterBuy + prices[index], // SELL now, skip a day
                tomorrowSell // SELL later
            );
            dayafterBuy = tomorrowBuy;
            tomorrowBuy = todayBuy;
        }
        return todayBuy;  // Return profit for buying from first day.
    }
}

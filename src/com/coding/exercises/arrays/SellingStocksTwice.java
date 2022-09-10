package com.coding.exercises.arrays;

public class SellingStocksTwice {
    public int maxProfit(int[] prices) {
        int[] leftMin = new int[prices.length];   // minimum price to the left so far.
        leftMin[0] = prices[0];
        for(int index = 1; index < prices.length; index++) {
            leftMin[index] = Math.min(leftMin[index-1], prices[index-1]);
        }

        int[] rightMax = new int[prices.length]; // maximum price to the right after this.
        rightMax[prices.length-1] = prices[prices.length-1];
        for(int index = prices.length-2; index >= 0; index--) {
            rightMax[index] = Math.max(rightMax[index+1], prices[index+1]);
        }
        int[] leftProfit = new int[prices.length]; // max profit to the left from today including current day.
        leftProfit[0] = 0;
        for(int index = 1; index < prices.length; index++) {
            leftProfit[index] = Math.max(prices[index] - leftMin[index], leftProfit[index-1]);
        }

        int[] rightProfit = new int[prices.length]; // max profit to the right starting from next day.
        rightProfit[prices.length-1] = 0;
        for(int index = prices.length-2; index >= 0; index--) {
            rightProfit[index] = Math.max( rightMax[index] - prices[index+1], rightProfit[index+1]);
        }

        int maxProfit = 0;
        for (int index = 0; index < prices.length; index++) {
            maxProfit = Math.max(maxProfit, leftProfit[index] + rightProfit[index]);
        }
        return maxProfit;
    }
}

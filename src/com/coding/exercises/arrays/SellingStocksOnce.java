package com.coding.exercises.arrays;

public class SellingStocksOnce {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minSoFar = Integer.MAX_VALUE;
        for (int price: prices) {
            if (minSoFar > price) {
                minSoFar = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minSoFar);
            }
        }
        return maxProfit;
    }
}

package com.coding.exercises.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    Map<Integer, Integer> minMap = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int ret = coinChangeSubProb(coins, amount);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    private int coinChangeSubProb(int[] coins, int amount) {
        if (minMap.containsKey(amount))
            return minMap.get(amount);

        if (amount == 0)
            return 0;

        if (amount < 0)
            return -1;

        int minCount = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (coin <= amount) {
                int count = coinChange(coins, amount - coin);
                if (count >= 0 && count < minCount)
                    minCount = 1+ count;
            }
        }
        int data = (minCount==Integer.MAX_VALUE) ? -1 : minCount;
        minMap.putIfAbsent(amount, data);
        return minCount;
    }
}

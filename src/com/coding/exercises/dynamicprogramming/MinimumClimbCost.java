package com.coding.exercises.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumClimbCost {
    Map<Integer, Integer> minCost = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }
        
        minCost(cost, cost.length - 1);
        return Math.min(minCost.get(cost.length - 1), minCost.get(cost.length - 2));
    }
    
    private int minCost(int[] cost, int level) {
        if (minCost.containsKey(level)) {
            // System.out.println("[Cached] Cost at level : " + level + " : " + cost[level]);
            return minCost.get(level);
        }
        
        if (level < 2) {
            // System.out.println("Cost at level : " + level + " : " + cost[level]);
            minCost.put(level, cost[level]);
            return cost[level];
        }
        
        int newCost = cost[level] + Math.min(minCost(cost, level-1), minCost(cost, level-2));
        // System.out.println("Calculated Cost at level : " + level + " : " + newCost);
        minCost.put(level, newCost);
        return newCost;
    }
}

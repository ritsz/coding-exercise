package com.coding.exercises.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumClimbs {
    Map<Integer, Integer> calculatedClimbs = new HashMap<>();
    
    public int climbStairs(int n) {
        return climbTillHere(n);
    }
    
    // Total  number of climbs to a spot depends on how many ways we can climb till n-1 and n-2.
    // This is basically a fibonacci function.
    private int climbTillHere(int height) {
        if (height == 1)
            return 1;
        
        if (height == 2)
            return 2;
        
        if (calculatedClimbs.containsKey(height)) return calculatedClimbs.get(height);
        
        int climbs = climbTillHere(height-1) + climbTillHere(height-2);
        
        calculatedClimbs.put(height, climbs);
        
        return climbs;
    }
}

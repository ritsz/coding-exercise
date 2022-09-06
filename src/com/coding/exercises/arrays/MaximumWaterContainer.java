package com.coding.exercises.arrays;

public class MaximumWaterContainer {
    
    public MaximumWaterContainer() {
    }

    public int maxArea(int[] height) {
        int result = 0;

        for (int i = 0, j = height.length-1; i < j; ) {
            int runningArea = Math.min(height[i], height[j])*(j-i);
            result = Math.max(result, runningArea);
            if (height[i] < height[i+1]) i++;
            if (height[j] < height[j-1]) j--;
        }

        return result;
    }

}

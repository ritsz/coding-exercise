package com.coding.exercises.stack;

public class RainWaterHarvesting {

    // Not using a stack, instead using 2 pointers that keep a track of max left and max right.
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        
        int left = 0, right = height.length - 1;
        int maxLeft = height[0], maxRight = height[height.length-1];
        int waterTrap = 0;
        
        while(left != right) {
            if (maxLeft <= maxRight) {
                // System.out.println("Checking water at : " + left);
                waterTrap += Math.max(0, maxLeft - height[left]);
                // System.out.println("Trapped water : " + waterTrap);
                left++;
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                    // System.out.println("Update maxLeft to : " + maxLeft);
                }
            } else {
                // System.out.println("Checking water at : " + right);
                waterTrap += Math.max(0, maxRight - height[right]);
                // System.out.println("Trapped water : " + waterTrap);
                right--;
                if (height[right] > maxRight) {
                    maxRight = height[right];
                    // System.out.println("Update maxRight to : " + maxRight);
                }
            }
        }
        return waterTrap;
    }
}

package com.coding.exercises.dynamicprogramming;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        int maxWithHead = rob(nums, 0, nums.length-2);
        // System.out.println("Max with HEAD: " + maxWithHead);
        
        int maxWithTail = rob(nums, 1, nums.length-1);
        // System.out.println("Max with TAIL: " + maxWithTail);
        
        return Math.max(maxWithHead, maxWithTail);
    }
    
    private int rob(int[] nums, int start, int end) {
        // System.out.println("Start: " + start);
        // System.out.println("End: " + end);
        
        int[][] dp = new int[nums.length-1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[start];
        int index = 1;
        for(; index < nums.length-1; index++) {
            dp[index][0] = Math.max(dp[index-1][0], dp[index-1][1]);
            dp[index][1] = nums[start+index] + dp[index-1][0];
        }
        
        return  Math.max(dp[index-1][0], dp[index-1][1]);
    }
}

package com.coding.exercises.dynamicprogramming;

public class HouseRobber1 {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int index = 1;
        for(; index < nums.length; index++) {
            // dp[][0] is the value if index is not robbed, so the maximum of previous level
            dp[index][0] = Math.max(dp[index-1][0], dp[index-1][1]);

            // dp[][1] is the value if index is robbed, so dp[index-1][0] because index-1 shouldn't be robbed.
            dp[index][1] = dp[index-1][0] + nums[index];
            // System.out.println("If index " + index + " is robbed : " + dp[index][1] + " and not robbed: " + dp[index][0]);
        }

        return Math.max(dp[index-1][0], dp[index-1][1]);
    }
}

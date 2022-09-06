package com.coding.exercises.dynamicprogramming;

import com.coding.exercises.utils.TreeNode;

public class HouseRobber3_2 {
    public int rob(TreeNode root) {
        int[] rootSum = robSub(root);
        return Math.max(rootSum[0], rootSum[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int leftSubTree[] = robSub(root.left);
        int rightSubTree[] = robSub(root.right);

        int[] rootSum = new int[2];
        // If root is not robbed.
        rootSum[0] = Math.max(leftSubTree[0], leftSubTree[1]) +  Math.max(rightSubTree[0], rightSubTree[1]);
        // If root is robbed.
        rootSum[1] = root.val + leftSubTree[0] + rightSubTree[0];
        return rootSum;
    }
}

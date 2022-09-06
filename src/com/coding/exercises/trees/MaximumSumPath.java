package com.coding.exercises.trees;

import com.coding.exercises.utils.TreeNode;

public class MaximumSumPath {
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }
    
    public int traverse(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftMaxPathSum = traverse(root.left);
        int rightMaxPathSum = traverse(root.right);
        
//         System.out.println("Rooted at : " + root.val);
//         System.out.println("LeftSum : " + leftMaxPathSum);
//         System.out.println("RightSum : " + rightMaxPathSum);
        if (leftMaxPathSum < 0) leftMaxPathSum = 0;
        if (rightMaxPathSum < 0) rightMaxPathSum = 0;
        
        maxSum = Math.max(maxSum, leftMaxPathSum + rightMaxPathSum + root.val);
        int maxPath = Math.max(leftMaxPathSum + root.val, rightMaxPathSum + root.val);
        // System.out.println("MaxSum via here : " + maxSum);
        // System.out.println("Max Sum Path till here : " + maxPath);
        return maxPath;
    }
}

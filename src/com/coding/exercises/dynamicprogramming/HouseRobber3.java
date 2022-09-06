package com.coding.exercises.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

import com.coding.exercises.utils.TreeNode;

public class HouseRobber3 {

    private Map<TreeNode, Integer> memoize = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memoize.containsKey(root)) {
            return memoize.get(root);
        }

        int val = root.val;

        if (root.left != null) {
            val += (rob(root.left.left) + rob(root.left.right));
        }

        if (root.right != null) {
            val += (rob(root.right.left) + rob(root.right.right));
        }
        
        val = Math.max(val, rob(root.left) + rob(root.right));
        memoize.put(root, val);

        return val;
    }
}

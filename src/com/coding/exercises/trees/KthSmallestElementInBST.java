package com.coding.exercises.trees;

import java.util.LinkedList;
import java.util.List;

import com.coding.exercises.utils.TreeNode;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return preOrder.get(k-1);
    }
    
    List<Integer> preOrder = new LinkedList<>();
    
    public void traverse(TreeNode root) {
        if (root == null) return;
        
        traverse(root.left);
        preOrder.add(root.val);
        traverse(root.right);
    }
}

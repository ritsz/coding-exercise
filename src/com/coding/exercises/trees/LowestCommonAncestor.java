package com.coding.exercises.trees;

import com.coding.exercises.utils.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        boolean leftContainsP = (p.val <= root.val);
        boolean rightContainsQ = (root.val <= q.val) ;
        if (leftContainsP && rightContainsQ) 
            return root;
        
        boolean rightContainsP = (root.val <= p.val);
        boolean leftContainsQ = (q.val <= root.val);
        if (rightContainsP && leftContainsQ)
            return root;
            
        if ((root == q) && (leftContainsP || rightContainsP))
            return root;
            
        if ((root == p) && (leftContainsQ || rightContainsQ))
            return root;
        
        if (leftContainsP && leftContainsQ)
            return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
    
    public boolean contains(TreeNode root, TreeNode check) {
        if (root == null) return false;
        
        if (root == check) return true;
        
        return contains(root.left, check) || contains(root.right, check);
    }
}

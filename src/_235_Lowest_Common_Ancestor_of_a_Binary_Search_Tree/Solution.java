package _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import DataStructures.TreeNode;

public class Solution {
    TreeNode p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        return getLowestCommonAncestor(root);
    }

    TreeNode getLowestCommonAncestor(TreeNode root) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = getLowestCommonAncestor(root.left);
        TreeNode right = getLowestCommonAncestor(root.right);
        if (left == null && right == null) return null;
        else if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}

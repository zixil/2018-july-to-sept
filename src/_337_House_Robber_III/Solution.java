package _337_House_Robber_III;

import javafx.util.Pair;

public class Solution {
    public int rob(TreeNode root) {
        return robRoot(root);
    }

    int robRoot(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robRoot(root.left) + robRoot(root.right), robLeaf(root.left) + robLeaf(root.right) + root.val);
    }

    int robLeaf(TreeNode root) {
        if (root == null) return 0;
        return robRoot(root.left) + robRoot(root.right);
    }
}

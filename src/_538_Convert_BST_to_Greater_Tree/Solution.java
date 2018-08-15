package _538_Convert_BST_to_Greater_Tree;

import DataStructures.TreeNode;

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        plus(root, 0);
        return root;
    }

    int plus(TreeNode root, int n) {
        if (root == null)
            return n;
        if (root.right == null)
            root.val += n;
        else
            root.val += plus(root.right, n);
        if (root.left != null)
            return plus(root.left, root.val);
        return root.val;
    }
}

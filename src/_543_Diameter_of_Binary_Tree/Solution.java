package _543_Diameter_of_Binary_Tree;

import DataStructures.TreeNode;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return getLen(new LenTreeNode(root));
    }

    class LenTreeNode {
        TreeNode node;
        LenTreeNode left, right;
        int len, lenRoot;

        LenTreeNode(TreeNode root) {
            node = root;
            if (root.left != null) {
                left = new LenTreeNode(root.left);
                len = left.len + 1;
                lenRoot = len;
            }
            if (root.right != null) {
                right = new LenTreeNode(root.right);
                len = Math.max(len, right.len + 1);
                lenRoot += right.len + 1;
            }
        }
    }

    int getLen(LenTreeNode root) {
        if (root == null) return 0;
        return Math.max(root.lenRoot, Math.max(getLen(root.left), getLen(root.right)));
    }

}

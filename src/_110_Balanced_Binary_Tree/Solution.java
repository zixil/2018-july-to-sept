package _110_Balanced_Binary_Tree;

import DataStructures.TreeNode;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        LayerNode newRoot = new LayerNode(root);
        return isBalanced(newRoot);
    }

    boolean isBalanced(LayerNode root) {
        if (root == null) return true;
        if (root.left == null) {
            if (root.right == null)
                return true;
            else
                return root.right.getHeight() == 1;
        } else if (root.right == null)
            return root.left.getHeight() == 1;
        int minHeight = root.getHeight()-2;
        return root.left.getHeight() >= minHeight
                && root.right.getHeight() >= minHeight
                && isBalanced(root.left)
                && isBalanced(root.right);
    }


    class LayerNode {
        TreeNode node;
        int height = -1;
        LayerNode left, right;

        LayerNode(TreeNode node) {
            this.node = node;
            left = node.left == null ? null : new LayerNode(node.left);
            right = node.right == null ? null : new LayerNode(node.right);
        }

        int getHeight() {
            if (height != -1) return height;
            int lH = 0;
            if (left != null) lH = left.getHeight();
            int rH = 0;
            if (right != null) rH = right.getHeight();
            height = 1 + Math.max(lH, rH);
            return height;
        }
    }
}

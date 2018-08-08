package _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import DataStructures.TreeNode;

public class Solution {
    int[] preOrder, inOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        return buildTree(0, preOrder.length, 0);
    }

    public TreeNode buildTree(int begin, int end, int preBegin) {
        if (begin == end) return null;
        for (int i = preBegin; i < preOrder.length; ++i) {
            for (int j = begin; j < end; ++j) {
                if (inOrder[j] == preOrder[i]) {
                    TreeNode res = new TreeNode(preOrder[i]);
                    res.left = buildTree(begin, j, i + 1);
                    res.right = buildTree(j + 1, end, i + 1);
                    return res;
                }
            }
        }
        return null;
    }
}

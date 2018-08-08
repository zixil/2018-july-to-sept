package _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import DataStructures.TreeNode;

public class Solution {
    int[] inOrder, postOrder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        return buildTree(0, inorder.length, postorder.length);
    }

    public TreeNode buildTree(int begin, int end, int postEnd) {
        if (begin == end) return null;
        for (int i = postEnd - 1; i >= 0; --i) {
            for (int j = begin; j < end; ++j) {
                if (inOrder[j] == postOrder[i]) {
                    TreeNode res = new TreeNode(inOrder[j]);
                    res.left = buildTree(begin, j, i);
                    res.right = buildTree(j + 1, end, i);
                    return res;
                }
            }
        }
        return null;
    }
}

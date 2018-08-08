package _606_Construct_String_from_Binary_Tree;

import DataStructures.TreeNode;

public class Solution {
    public String tree2str(TreeNode t) {
        if (t.left == null && t.right == null) return String.valueOf(t.val);
        StringBuilder res = new StringBuilder(String.valueOf(t.val));
        if (t.left == null) return res.append("()(").append(tree2str(t.right)).append(")").toString();
        if (t.right == null) return res.append("(").append(tree2str(t.left)).append(")").toString();
        return res.append("(").append(tree2str(t.left)).append(")(").append(tree2str(t.right)).append(")").toString();
    }
}

package _101_Symmetric_Tree;

import DataStructures.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isEqual(root.left,root.right);
    }
    public boolean isEqual(TreeNode r1,TreeNode r2){
        if(r1==null) return r2==null;
        if(r2==null) return false;
        return r1.val==r2.val&&isEqual(r1.left,r2.right)&&isEqual(r1.right,r2.left);
    }
}

package _872_Leaf_Similar_Trees;

import DataStructures.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> l1 = leafSequence(root1), l2 = leafSequence(root2);
        if (l1.size() != l2.size()) return false;
        Iterator<Integer> i1 = l1.iterator(), i2 = l2.iterator();
        while (i1.hasNext()) {
            if (i1.next() != i2.next()) return false;
        }
        return true;
    }

    LinkedList<Integer> leafSequence(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        if (root.left != null)
            res.addAll(leafSequence(root.left));
        if (root.right != null)
            res.addAll(leafSequence(root.right));
        return res;
    }

}

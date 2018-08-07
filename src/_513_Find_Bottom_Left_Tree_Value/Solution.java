package _513_Find_Bottom_Left_Tree_Value;

import DataStructures.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> curLayer = new LinkedList<>();
        LinkedList<TreeNode> nextLayer = new LinkedList<>();
        curLayer.add(root);
        Iterator<TreeNode> iter = curLayer.iterator();
        while (true) {
            TreeNode tmp = iter.next();
            if (tmp.left != null) nextLayer.add(tmp.left);
            if (tmp.right != null) nextLayer.add(tmp.right);
            if (!iter.hasNext()) {
                if (nextLayer.isEmpty())
                    return curLayer.getFirst().val;
                else {
                    curLayer = nextLayer;
                    nextLayer = new LinkedList<>();
                    iter = curLayer.listIterator();
                }
            }
        }
    }
}

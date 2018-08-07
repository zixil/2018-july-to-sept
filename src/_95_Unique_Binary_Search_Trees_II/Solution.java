package _95_Unique_Binary_Search_Trees_II;

import DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        if (n == 1) {
            List<TreeNode> list = new LinkedList<>();
            list.add(new TreeNode(1));
            return list;
        }
        return generateTrees(0, n);
    }

    List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start == end) {
            list.add(null);
            return list;
        }
        if (end - start == 1) {
            list.add(new TreeNode(start + 1));
            return list;
        }
        for (int mid = start; mid < end; ++mid) {
            List<TreeNode> left = generateTrees(start, mid);
            List<TreeNode> right = generateTrees(mid + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode midNode = new TreeNode(mid + 1);
                    midNode.left = l;
                    midNode.right = r;
                    list.add(midNode);
                }
            }
        }
        return list;
    }
}

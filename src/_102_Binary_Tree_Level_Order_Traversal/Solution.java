package _102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<NodeLayer> que = new LinkedList<>();
        que.add(new NodeLayer(root, 0));
        while (!que.isEmpty()) {
            NodeLayer tmp = que.poll();
            TreeNode node = tmp.node;
            int layer = tmp.layer;
            if (node.left != null)
                que.add(new NodeLayer(node.left, layer + 1));
            if (node.right != null)
                que.add(new NodeLayer(node.right, layer + 1));
            if(layer>=list.size()) list.add(new LinkedList<>());
            list.get(layer).add(node.val);
        }
        return list;
    }

    class NodeLayer {
        TreeNode node;
        int layer;

        NodeLayer(TreeNode node, int layer) {
            this.node = node;
            this.layer = layer;
        }
    }
}

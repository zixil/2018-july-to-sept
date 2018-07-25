package _684_Redundant_Connection;

public class Solution {
    int len;
    boolean[][] e;
    JointSet[] v;

    public int[] findRedundantConnection(int[][] edges) {
        len = edges.length;
        v = new JointSet[len];
        for (int i = 0; i < len; ++i) {
            v[i] = new JointSet(i);
        }
        int[] result = null;
        for (int[] i : edges) {
            if(v[i[0]-1].sameSet(v[i[1]-1]))
                result=i;
            else
                v[i[0]-1].add(v[i[1]-1]);
        }
        return result;
    }

    class JointSet {
        Integer n;
        JointSet root;

        JointSet(Integer n) {
            this.n = n;
            this.root = null;
        }

        JointSet getRoot() {
            if (root == null) return this;
            while (root.root != null) {
                root = root.root;
            }
            return root;
        }

        boolean sameSet(JointSet b) {
            return getRoot() == b.getRoot();
        }

        void add(JointSet b) {
            b.getRoot().root = getRoot();
        }
    }

}

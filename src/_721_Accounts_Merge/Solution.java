package _721_Accounts_Merge;

import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<JointSet>> map = new HashMap<>();
        for (List<String> i : accounts) {
            List<JointSet> tmp = map.getOrDefault(i, new LinkedList<>());
            tmp.add(new JointSet(new HashSet<>(i)));
            map.put(i.get(0), tmp);
        }
        for (List<JointSet> i : map.values()) {
            Iterator<JointSet> iter1 = i.iterator();
            int j1 = 0;
            i1:
            while (iter1.hasNext()) {
                JointSet tmp1=iter1.next();
                Set<String> set1=tmp1.set;
                Iterator<JointSet> iter2 = i.iterator();
                int j2 = 0;
                i2:
                while (j2++ < j1) {
                    JointSet tmp2=iter2.next();
                    Set<String> set2=tmp2.set;
                    for(String k:set2){
                        if(set1.contains(k)){
                            tmp1.add(tmp2);
                            break i2;
                        }
                    }
                }
                ++j1;
            }
        }
        
    }

    class JointSet {
        JointSet root;
        Set<String> set;

        JointSet(Set<String> set) {
            this.set = set;
        }

        JointSet getRoot() {
            return root == null ? this : root.getRoot();
        }

        void add(JointSet n) {
            n.getRoot().root = getRoot();
        }

        void clear() {
            if (root != null) root = getRoot();
        }

    }
}

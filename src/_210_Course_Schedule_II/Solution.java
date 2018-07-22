package _210_Course_Schedule_II;

import java.util.*;

public class Solution {
    int numCourses;
    LinkedList<Integer>[] prerequisites, postrequisites;
    boolean[] added;
    boolean[] curPre;
    LinkedList<Integer> roots;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        this.numCourses = numCourses;
        this.prerequisites = new LinkedList[numCourses];
        this.postrequisites = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            this.prerequisites[i] = new LinkedList<>();
            this.postrequisites[i] = new LinkedList<>();
        }
        for (int[] i : prerequisites) {
            this.prerequisites[i[0]].add(i[1]);
            this.postrequisites[i[1]].add(i[0]);
        }

        added = new boolean[numCourses];
        curPre = new boolean[numCourses];
        roots = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (this.postrequisites[i].size() == 0) {
                roots.add(i);
            }
        }
        if (hasCircle()) return new int[0];

        LinkedList<Integer> list = BFS();
        if (list.size() < numCourses) return new int[0];
        int[] result = new int[numCourses];
        ListIterator<Integer> iter = list.listIterator();
        for (int i = numCourses - 1; i >= 0; --i) {
            result[i] = iter.next();
        }
        return result;
    }

    boolean hasCircle() {
        for (Integer i : roots)
            if (hasCircle(i))
                return true;
        return false;
    }

    boolean hasCircle(int root) {
        curPre[root] = true;
        for (Integer i : prerequisites[root]) {
            if (curPre[i]) return true;
            else if (hasCircle(i)) return true;
        }
        curPre[root] = false;
        return false;
    }

    LinkedList<Integer> BFS() {
        LinkedList<Integer> list = new LinkedList<>();
        while (!roots.isEmpty()) {
            int tmp = roots.poll();
            if (!added[tmp]&&postAdded(tmp)) {
                list.add(tmp);
                added[tmp] = true;
                for (Integer i : this.prerequisites[tmp])
                    if (!added[i])
                        roots.add(i);
            }
        }
        return list;
    }

    boolean postAdded(int n){
        for(Integer i:postrequisites[n]) if(!added[i]) return false;
        return true;
    }
}

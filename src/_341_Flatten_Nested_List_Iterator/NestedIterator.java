package _341_Flatten_Nested_List_Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> s = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        s.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        Iterator<NestedInteger> tmp = s.pop();
        while (!tmp.hasNext()) {
            tmp = s.pop();
        }
        NestedInteger tmpN = tmp.next();
        s.push(tmp);
        if (tmpN.isInteger()) return tmpN.getInteger();
        tmp = tmpN.getList().iterator();
        s.push(tmp);
        return this.next();
    }

    @Override
    public boolean hasNext() {
        Iterator<NestedInteger> tmp = s.pop();
        while (tmp.hasNext() || !tmp.hasNext() && !s.isEmpty()) {
            if (tmp.hasNext()) {
                NestedInteger tmpN = tmp.next();
                if (tmpN.isInteger()) {
                    s.push(tmp);
                    LinkedList<NestedInteger> tmpList=new LinkedList<>();
                    tmpList.add(tmpN);
                    s.push(tmpList.iterator());
                    return true;
                }
                s.push(tmp);
                tmp = tmpN.getList().iterator();
            } else if (!tmp.hasNext()) {
                tmp = s.pop();
            }
        }
        s.push(tmp);
        return tmp.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
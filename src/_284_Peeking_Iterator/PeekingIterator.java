package _284_Peeking_Iterator;

import DataStructures.ListNode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    ListNode head;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        head = new ListNode(iterator.next());
        ListNode tmp = head;
        while (iterator.hasNext()) {
            tmp.next = new ListNode(iterator.next());
            tmp = tmp.next;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return head.val;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer tmp = head.val;
        head = head.next;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

}


package _146_LRU_Cache;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    HashMap<Integer, DoubleListNode> index = new HashMap<>();
    DoubleListNode head, tail;
    int size, maxSize;


    public LRUCache(int capacity) {
        maxSize = capacity;
    }

    public int get(int key) {
        if (index.containsKey(key)) {
            DoubleListNode node = index.get(key);
            node.update();
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        System.out.println(size);
        if (index.containsKey(key)) {
            DoubleListNode node = index.get(key);
            node.update();
            node.val = value;
            return;
        }
        if (size == maxSize) {
            index.remove(head.key);
            System.out.println(head.key);
            head.remove();
        }
        DoubleListNode node = new DoubleListNode(key, value);
        node.add();
        index.put(key, node);
    }

    class DoubleListNode {
        int key, val;
        DoubleListNode pre, next;

        DoubleListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        void remove() {
            if (size == 1) {
                head = tail = null;
                --size;
                return;
            }
            if (this != head) {
                pre.next = next;
            } else {
                head = next;
                head.pre = null;
            }
            if (this != tail) {
                next.pre = pre;
            } else {
                tail = pre;
                tail.next = null;
            }
            --size;
        }

        void add() {
            if (size == 0) {
                head = tail = this;
                ++size;
                return;
            }
            tail.next = this;
            this.pre = tail;
            this.next = null;
            tail = this;
            ++size;
        }

        void update() {
            if (size > 1) {
                remove();
                add();
            }
        }
    }
}

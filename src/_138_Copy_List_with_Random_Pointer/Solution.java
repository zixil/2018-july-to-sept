package _138_Copy_List_with_Random_Pointer;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            ++len;
        }
        RandomListNode[] array = new RandomListNode[len];
        array[0] = new RandomListNode(head.label);
        head.label = 0;
        cur = head.next;
        for (int i = 1; i < len; ++i) {
            array[i] = new RandomListNode(cur.label);
            array[i - 1].next = array[i];
            cur.label = i;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < len; ++i) {
            if (cur.random != null) array[i].random = array[cur.random.label];
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < len; ++i) {
            cur.label = array[i].label;
            cur = cur.next;
        }
        return array[0];
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }


}

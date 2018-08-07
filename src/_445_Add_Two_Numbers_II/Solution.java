package _445_Add_Two_Numbers_II;

import DataStructures.ListNode;

import java.util.Iterator;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode p1 = l1, p2 = l2;
        int len1 = 1, len2 = 1;
        while (p1.next != null) {
            p1 = p1.next;
            ++len1;
        }
        while (p2.next != null) {
            p2 = p2.next;
            ++len2;
        }
        if (len1 < len2) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
            int tmpLen = len1;
            len1 = len2;
            len2 = tmpLen;
        }
        p1 = l1;
        p2 = l2;
        ListNode l3 = new ListNode(0), p3 = l3;
        for (int i = 0; i < len1 - len2; ++i) {
            p3.next = new ListNode(p1.val);
            p1 = p1.next;
            p3 = p3.next;
        }
        for (int i = 0; i < len2; ++i) {
            p3.next = new ListNode(p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
            p3 = p3.next;
        }
        l3 = l3.next;
        l3 = reverse(l3);
        p3 = l3;
        while (p3 != null) {
            if (p3.val / 10 != 0) {
                if (p3.next == null) p3.next = new ListNode(1);
                else p3.next.val++;
                p3.val -= 10;
            }
            p3 = p3.next;
        }
        l3 = reverse(l3);
        return l3;
    }

    ListNode reverse(ListNode list) {
        ListNode pre = null;
        while (list != null) {
            ListNode tmpNext = list.next;
            list.next = pre;
            pre = list;
            list = tmpNext;
        }
        return pre;
    }
}

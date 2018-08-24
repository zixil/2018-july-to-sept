package _2_Add_Two_Numbers;

import DataStructures.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        if (l1 == null) return l2;
        ListNode head = l1;
        l1.val += l2.val;
        int carry = l1.val / 10;
        l1.val %= 10;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            l1.val += l2.val + carry;
            carry = l1.val / 10;
            l1.val %= 10;
        }
        if (l1.next == null) {
            l1.next = l2.next;
        }
        while (l1.next != null && carry != 0) {
            l1 = l1.next;
            l1.val += carry;
            carry = l1.val / 10;
            l1.val %= 10;
        }
        if (carry != 0)
            l1.next = new ListNode(1);
        return head;
    }
}

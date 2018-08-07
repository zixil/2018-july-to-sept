package _141_Linked_List_Cycle;

import DataStructures.ListNode;

public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            ListNode newTmp = tmp.next;
            tmp.next = head;
            tmp = newTmp;
            if (tmp == head) return true;
        }
        return false;
    }

}

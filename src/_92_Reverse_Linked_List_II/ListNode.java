package _92_Reverse_Linked_List_II;

public class ListNode {
    int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if(next!=null){
            return val+","+next.toString();
        }
        return String.valueOf(val);
    }
}

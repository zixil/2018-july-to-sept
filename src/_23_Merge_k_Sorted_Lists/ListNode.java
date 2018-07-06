package _23_Merge_k_Sorted_Lists;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static public ListNode fromArray(int[] array){
        ListNode head=new ListNode(0);
        ListNode tail=head;
        for(int i:array){
            tail.next=new ListNode(i);
            tail=tail.next;
        }
        return head.next;
    }
    static public ListNode[] fromArrays(int[][] array){
        ListNode[] result=new ListNode[array.length];
        for(int i=0;i<array.length;++i) result[i]=fromArray(array[i]);
        return result;
    }

    @Override
    public String toString() {
        ListNode tmp=this;
        String result="";
        while(tmp!=null){
            result+=String.valueOf(tmp.val)+" ";
            tmp=tmp.next;
        }
        return result;
    }
}

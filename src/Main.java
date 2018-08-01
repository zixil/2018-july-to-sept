import _870_Advantage_Shuffle.*;

public class Main {
    public static void main(String[] args) {
        /*
        int[] array={1,2,3,4,5};
        ListNode head=new ListNode(0);
        ListNode tail=head;
        for(int i:array){
            tail.next=new ListNode(i);
            tail=tail.next;
        }
        ListNode tmp=head;
        for(int i=0;i<6;++i) {
            tmp=tmp.next;
        }
        tail.next = tmp;*/

        int[] array1 = {817556235, 232246148, 424291784, 13856114, 113666578, 513996259, 791310549, 341026786, 319348491, 40812144};
        int[] array2 = {99616046, 148514886, 206257807, 569848817, 358893433, 977727091, 284109958, 856279522, 91774240, 527604738};
        System.out.println(new Solution().advantageCount(array1,array2));
    }
}
import _23_Merge_k_Sorted_Lists.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] arrays={{1,4,5},{1,3,4},{2,6}};
        System.out.println(new Solution().mergeKLists(ListNode.fromArrays(arrays)));
    }
}
package _448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0)
                continue;
            int tmpI = nums[i] - 1;
            nums[i] = 0;
            while (nums[tmpI] >= 1) {
                int tmpN = nums[tmpI];
                nums[tmpI] = -1;
                tmpI = tmpN - 1;
            }
            if (nums[tmpI] == 0)
                nums[tmpI] = -1;
        }
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0)
                res.add(i + 1);
        }
        return res;
    }
}

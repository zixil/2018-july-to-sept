package _53_Maximum_Subarray;

import java.util.Arrays;

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;++i){
            if(nums[i]>0){
                int tmpSum=nums[i];
                int curSum=tmpSum;
                for(int j=i+1;j<nums.length;++j){
                    curSum+=nums[j];
                    tmpSum=Math.max(tmpSum,curSum);
                    if(curSum<=0) break;
                }
                sum=Math.max(sum,tmpSum);
            }
        }
        if(sum==Integer.MIN_VALUE)
            return Arrays.stream(nums).max().getAsInt();
        return sum;
    }
}

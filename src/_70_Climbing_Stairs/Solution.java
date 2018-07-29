package _70_Climbing_Stairs;

public class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int pre=1;
        int cur=1;
        int i=1;
        while(i++<n){
            int tmp=pre;
            pre=cur;
            cur+=tmp;
        }
        return cur;
    }
}

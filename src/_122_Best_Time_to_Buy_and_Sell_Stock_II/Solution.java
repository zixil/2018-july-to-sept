package _122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = min;
        for (int i : prices) {
            if (i < max) {
                result += max - min;
                min=max=i;
            }
            else{
                max=i;
            }
        }
        return result+max-min;
    }
}

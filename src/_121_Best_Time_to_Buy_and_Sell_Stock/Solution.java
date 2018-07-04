package _121_Best_Time_to_Buy_and_Sell_Stock;

import java.util.ArrayList;

public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        if (length == 2) return Math.max(0, prices[1] - prices[0]);
        int cluster = 0;
        for (int i = 2; i < length; ++i) {
            if (((prices[i] - prices[cluster + 1]) ^ (prices[cluster + 1] - prices[cluster])) < 0) {
                prices[cluster] = prices[cluster + 1] - prices[cluster];
                ++cluster;
            }
            prices[cluster + 1] = prices[i];
        }
        prices[cluster] = prices[cluster + 1] - prices[cluster];
        length = cluster + 1;
        if (length == 1) return Math.max(0, prices[0]);
        if (length == 2) return Math.max(prices[0], prices[1]);
        for (int i = prices[0] < 0 ? 3 : 2; i < length; i += 2)
            prices[i] = Math.max(prices[i] + prices[i - 1] + prices[i - 2], prices[i]);
        int max = prices[0];
        for (int i = 1; i < length; ++i)
            if (max < prices[i]) max = prices[i];
        return max;
    }
}

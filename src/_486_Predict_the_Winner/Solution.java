package _486_Predict_the_Winner;

import java.util.Arrays;

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] maxScore = new int[nums.length][nums.length];
        int[][] sumScore = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; ++i) {
            maxScore[i][i] = nums[i];
            sumScore[i][i] = nums[i];
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            maxScore[i][i + 1] = Math.max(nums[i], nums[i + 1]);
            sumScore[i][i + 1] = nums[i] + nums[i + 1];
        }
        for (int n = 1; n < (nums.length + 1) / 2; n++) {
            for (int i = n; i < nums.length - n; ++i) {
                sumScore[i - n][i + n] = sumScore[i - n + 1][i + n] + sumScore[i - n][i + n - 1] - sumScore[i - n + 1][i + n - 1];
                int first = nums[i - n] + sumScore[i - n + 1][i + n] - maxScore[i - n + 1][i + n];
                int last = nums[i + n] + sumScore[i - n][i + n - 1] - maxScore[i - n][i + n - 1];
                maxScore[i - n][i + n] = Math.max(first, last);
            }
            for (int i = n; i < nums.length - n-1; ++i) {
                sumScore[i - n][i + n + 1] = sumScore[i - n + 1][i + n + 1] + sumScore[i - n][i + n] - sumScore[i - n + 1][i + n];
                int first = nums[i - n] + sumScore[i - n + 1][i + n + 1] - maxScore[i - n + 1][i + n + 1];
                int last = nums[i + n + 1] + sumScore[i - n][i + n] - maxScore[i - n][i + n];
                maxScore[i - n][i + n + 1] = Math.max(first, last);
            }
        }
        int sum = 0;
        for (int i : nums) sum += i;
        int score1 = maxScore[0][nums.length - 1], score2 = sum - score1;
        System.out.println(score1);
        return score1 >= score2;
    }
}

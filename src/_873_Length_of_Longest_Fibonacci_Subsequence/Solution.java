package _873_Length_of_Longest_Fibonacci_Subsequence;

public class Solution {
    int[] A;
    int len;
    int[][] add;

    public int lenLongestFibSubseq(int[] A) {
        this.A = A;
        len = A.length;
        add = new int[len][len];
        getAdd();

        int longest = 0;
        for (int i = 0; i < len - 2; ++i) {
            for (int j = i + 1; j < len - 1; ++j) {
                if (add[i][j] != 0) longest = Math.max(longest, 1 + lenLongestFibSubseq(j, add[i][j]));
            }
        }

        return longest;
    }

    int lenLongestFibSubseq(int first, int second) {
        if (add[first][second] == 0) return 2;
        return 1 + lenLongestFibSubseq(second, add[first][second]);
    }

    void getAdd() {
        for (int i = 0; i < len - 2; ++i) {
            for (int j = i + 1; j < len - 1; ++j) {
                int sum = A[i] + A[j];
                if (j == len - 2) {
                    if (A[len - 1] == sum) add[i][j] = len - 1;
                    break;
                }
                int min = j + 1, max = len - 1;
                while (min + 1 < max) {
                    int mid = (max + min) / 2;
                    if (A[mid] > sum) max = mid;
                    else if (A[mid] < sum) min = mid;
                    else {
                        add[i][j] = mid;
                        break;
                    }
                }
                if (A[min] == sum) {
                    add[i][j] = min;
                } else if (A[max] == sum) {
                    add[i][j] = max;
                }
            }
        }
    }
}

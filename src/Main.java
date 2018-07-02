import _73_Set_Matrix_Zeroes.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {0},{1}
        };
        new Solution().setZeroes(array);
        for (int[] i : array) {

            System.out.println(Arrays.toString(i));
        }

    }
}

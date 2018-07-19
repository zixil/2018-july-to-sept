package _93_Restore_IP_Addresses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    char[] s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s.toCharArray();
        LinkedList<int[]> list = new LinkedList<>();
        list.addAll(getList(s.length(), 4));
        LinkedList<int[]> validList = new LinkedList<>();
        for (int[] i : list) {
            int[] sum = new int[4];
            if (i[0] == 3 && !blockvalid3(0)|| i[0] == 2 && !blockvalid2(0)) continue;
            sum[0] = i[0];
            boolean valid = true;
            for (int j = 1; j < 4; ++j) {
                sum[j] = i[j] + sum[j - 1];
                if (i[j] == 3 && !blockvalid3(sum[j - 1]) || i[j] == 2 && !blockvalid2(sum[j - 1])) {
                    valid = false;
                    break;
                }
            }
            if (valid) validList.add(sum);
        }
        LinkedList<String> result = new LinkedList<>();
        for (int[] i : validList) {
            StringBuilder sb = new StringBuilder(s.substring(0, i[0]));
            for (int j = 0; j < 3; ++j) {
                sb.append('.').append(s.substring(i[j], i[j + 1]));
            }
            result.add(sb.toString());
        }
        return result;
    }

    public boolean blockvalid3(int start) {
        return s[start] < '2' && s[start] != '0'
                || s[start] == '2' && s[start + 1] < '5'
                || s[start] == '2' && s[start + 1] == '5' && s[start + 2] <= '5';
    }

    public boolean blockvalid2(int start) {
        return s[start] != '0';
    }


    public LinkedList<int[]> getList(int len, int block) {
        if (len < block || len > 3 * block || block <= 0) return new LinkedList<>();
        LinkedList<int[]> result = new LinkedList<>();

        if (block == 1) {
            int[] tmp = new int[4];
            tmp[0] = len;
            result.add(tmp);
            return result;
        }

        LinkedList<int[]> result1 = getList(len - 1, block - 1);
        for (int[] i : result1) i[block - 1] = 1;
        result.addAll(result1);
        LinkedList<int[]> result2 = getList(len - 2, block - 1);
        for (int[] i : result2) i[block - 1] = 2;
        result.addAll(result2);
        LinkedList<int[]> result3 = getList(len - 3, block - 1);
        for (int[] i : result3) i[block - 1] = 3;
        result.addAll(result3);
        return result;
    }

}

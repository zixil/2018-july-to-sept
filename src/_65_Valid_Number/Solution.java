package _65_Valid_Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public boolean isNumber(String s) {
        //spaces
        String[] ss = s.split(" ");
        List<String> list = Arrays.stream(ss).filter((i) -> !i.equals("")).collect(Collectors.toList());
        if (list.size() != 1) return false;
        s = list.get(0);
        //e
        ss = s.split("[eE]", -1);
        if (ss.length == 1) {
            return isNotNullFloat(unsigned(ss[0]));
        } else if (ss.length == 2) {
            return ss[0].length() != 0 && isNotNullFloat(unsigned(ss[0])) && ss[1].length() != 0 &&
                    isNotNullInt(unsigned(ss[1]));
        } else return false;
    }

    String unsigned(String s) {
        return s.charAt(0) == '+' || s.charAt(0) == '-' ? s.substring(1) : s;
    }

    boolean isInt(String s) {
        for (char i : s.toCharArray()) if (i > '9' || i < '0') return false;
        return true;
    }

    boolean isNotNullInt(String s) {
        return s.length() != 0 && isInt(s);
    }

    boolean isFloat(String s) {
        if (s.equals(".")) return false;
        String[] ss = s.split("\\.", -1);
        if (ss.length > 2 || ss.length < 1) return false;
        if (isInt(ss[0]) && (ss.length == 1 || isInt(ss[1]))) return true;
        return false;
    }

    boolean isNotNullFloat(String s) {
        return s.length() != 0 && isFloat(s);
    }
}

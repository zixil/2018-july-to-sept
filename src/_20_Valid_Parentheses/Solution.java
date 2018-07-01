package _20_Valid_Parentheses;

import java.util.LinkedList;

public class Solution {

    public boolean isValid(String s) {
        LinkedList<Character> sL = new LinkedList<>();
        char[] sA = s.toCharArray();
        for (char i : sA) {
            if (i == '(' || i == '[' || i == '{') sL.add(i);
            else if (sL.isEmpty()) return false;
            else if (i == ')') {
                if (sL.getLast() == '(') sL.removeLast();
                else return false;
            } else if (i == ']') {
                if (sL.getLast() == '[') sL.removeLast();
                else return false;
            } else if (i == '}') {
                if (sL.getLast() == '{') sL.removeLast();
                else return false;
            }
        }
        return sL.isEmpty();
    }

}

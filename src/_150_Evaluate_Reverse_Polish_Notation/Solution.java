package _150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        for(String i:tokens){
            if(i.equals("+")){
                s.push(s.pop()+s.pop());
            } else if(i.equals("-")){
                int a2=s.pop(),a1=s.pop();
                s.push(a1-a2);
            } else if(i.equals("*")){
                s.push(s.pop()*s.pop());
            } else if(i.equals("/")){
                int a2=s.pop(),a1=s.pop();
                s.push(a1/a2);
            } else s.push(Integer.parseInt(i));
        }
        return s.pop();
    }
}

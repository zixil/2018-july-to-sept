package _301_Remove_Invalid_Parentheses;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int stack=0;
        ArrayList<Integer> que=new ArrayList<>();
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;++i){
            if(c[i]=='(') ++stack;
            if(c[i]==')') {
                if(stack==0) que.add(i);
                else --stack;
            }

        }
    }
}

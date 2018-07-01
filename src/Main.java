import _139_Word_Break.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
/*
        List<String> dict= Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
*/        List<String> dict= Arrays.asList("apple", "pen");
        System.out.println(new Solution().wordBreak("applepenapple", dict));

    }
}

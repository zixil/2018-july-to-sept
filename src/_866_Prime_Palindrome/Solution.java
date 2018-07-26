package _866_Prime_Palindrome;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Solution {
    LinkedList<Integer> primeList;
    int[] parlindromeList;
    final static int size = 14200;
    int N;
    int listSize;

    public int primePalindrome(int N) {
        this.N = N;
        getPrime();
        getParlindrome();
        for (int i : parlindromeList) {
            System.out.println(i);
            if (i >= N && prime(i)) return i;
        }
        return 0;
    }

    boolean parlindrome(int N) {
        int tmpN = N;
        LinkedList<Integer> ns = new LinkedList<>();
        while (tmpN > 0) {
            ns.add(tmpN % 10);
            tmpN /= 10;
        }
        int len = ns.size();
        Integer[] nc = new Integer[len];
        ns.toArray(nc);
        for (int i = 0; i < len / 2; ++i) {
            if (nc[len - 1 - i] != nc[i]) return false;
        }
        return true;
    }

    boolean prime(int N) {
        if (N == 1) return false;
        for (Integer i : primeList) {
            if (i * i > N) return true;
            if (N % i == 0) return false;
        }
        return false;
    }

    void getPrime() {
        primeList = new LinkedList<>();
        primeList.add(2);
        int[] num = new int[size];
        for (int i = 0; i < size; ++i) num[i] = i + 2;
        first:
        for (int i = 0; i < size; ++i) {
            if (num[i] == 0) continue;
            int tmp = num[i];/*
            for (Integer j : primeList) {
                if (tmp % j == 0) {
                    for (int k = 2; tmp * k - 2 < size; ++k) {
                        num[tmp * k - 2] = 0;
                    }
                    continue first;
                }
                if (j * j > tmp) break;
            }*/
            primeList.add(tmp);
            for (int k = 2; tmp * k - 2 < size; ++k) {
                num[tmp * k - 2] = 0;
            }
        }
    }

    void getParlindrome() {
        LinkedList<String> parlindromeString = new LinkedList<>();
        LinkedList<String> Single = new LinkedList<>();
        for (int i = 0; i <= 9; ++i) {
            String tmp = String.valueOf(i);
            Single.add(tmp);
        }
        parlindromeString.addAll(Single);
        parlindromeString.add("11");
        for (int n = (int) Math.sqrt(N); n <= 20000; ++n) {
            String tmp = String.valueOf(n);
            parlindromeString.add(tmp + new StringBuilder(tmp).deleteCharAt(tmp.length() - 1).reverse().toString());
        }
        parlindromeList = new int[parlindromeString.size()];
        int iL = 0;
        for (String i : parlindromeString) {
            int tmp = Integer.parseInt(i);
            if (tmp >= N)
                parlindromeList[iL++] = Integer.parseInt(i);
        }
        listSize = iL;
    }
}

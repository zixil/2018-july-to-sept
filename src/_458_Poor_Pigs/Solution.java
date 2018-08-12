package _458_Poor_Pigs;

public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int round = minutesToTest / minutesToDie;/*
        System.out.println(Math.log(round) / Math.log(2));
        return (int) Math.ceil(Math.log(buckets) / Math.log(2) / round + (round - 1) / 2.0);
        */
        return (int)Math.ceil(Math.log(buckets)/Math.log(round+1));
    }
}

/*
     Day 91: Leetcode 123. Best Time to Buy and Sell Stock III
     Time : 23 mins
     500 / 596 test cases passed.
     
     Personal notes: Intuition on buy and sell
*/


class Solution {
    public int maxProfit(int[] p) {
        if(p.length==0){
            return 0;
        }
        
        int fb=Integer.MIN_VALUE,sb=Integer.MIN_VALUE;
        int fs=0,ss=0;
        int i=0;
        while(i<p.length){
            fb=Math.max(fb,-p[i]);
            fs=Math.max(fs,fb+p[i]);
            sb=Math.max(sb,fs-p[i]);
            ss=Math.max(ss,sb+p[i]);
            i+=1;
        }
        
        return ss;
    }
}
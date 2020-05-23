/*
     Day 77: Leetcode 453. Minimum Moves to Equal Array Elements
     Time Spent: 19 mins
     
     Personal notes: edge cases
*/


import java.util.Collections;
import java.util.*;
class Solution {
    public int minMoves(int[] nums) {
        
        
        Integer min = Integer.MAX_VALUE;

        for(int cur: nums){
            min = Math.min(min, cur);
        }
          
        int res=0;
        for(int n:nums){
            
                res+=n-min;
            
        }
        return res;
    }
}
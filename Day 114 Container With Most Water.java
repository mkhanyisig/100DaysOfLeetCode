/*
     Day 110: Leetcode  11. Container With Most Water

     Time Spent: 28 mins 
     
     Personal notes: Similar to trapping rainwater
*/



class Solution {
    public int maxArea(int[] A) {
        int l = 0; 
        int r = A.length -1; 
        int area = 0; 
      
        while (l < r) 
        { 
            // Calculating the max area 
            area = Math.max(area,  
                        Math.min(A[l], A[r]) * (r - l)); 
                          
            if (A[l] < A[r]) 
                l += 1; 
                  
            else
                r -= 1; 
        } 
        return area; 
    }
}
/*
     Day 29: Leetcode 
     Time Spent: 8 mins
     
     Personal notes: More so understanding the logic
     
*/


class Solution {
    public int getSum(int x, int y) {
        while (y != 0){  // iterate till there are no carries
            // carry now contains common 
            // set bits of x and y 
            int carry = x & y; 
  
            // Sum of bits of x and  
            // y where at least one  
            // of the bits is not set 
            // X OR operator
            x = x ^ y; 
  
            // Carry is shifted by  
            // one so that adding it  
            // to x gives the required sum 
            y = carry << 1; 
        } 
        return x; 
    }
}
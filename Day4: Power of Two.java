/*
     Day 4: Leetcode 231. Power of Two
     Time Spent: 30 mins
     
     Personal notes: Eliminate cases of odd factors and then get down to remainders
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1){
            return true; 
        }
        // eliminate all odd numbers since not divisible by 2
        if(n%2 >0){
            return false;
        }
        // once down to two, check if two is 
        if(n<=2){
            if(n==2){
                return true;
            }
            else{
                return false;
            }
        } 
        /* // useless
        float half = (float) n;
        half = half/(float)2.0;
        System.out.println(" half "+half);
        if(half<4.0) {
            if(half==2.0){
                return true;
            }
            else{
                return false;
            }
        } 
        */
        
        return isPowerOfTwo(n/2);    
    }
}

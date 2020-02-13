/*
     Day 4: Leetcode 326. Power of Three
     Time Spent: 4 mins
     
     Personal notes: After power of two, hacked this solution. Eliminate cases of factors and then get down to remainders
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true; 
        }
        // eliminate all odd numbers since not divisible by 3
        if(n%3 >0){
            return false;
        }
        // once down to two, check if two is 
        if(n<=3){
            if(n==3){
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
        
        return isPowerOfThree(n/3); 
}

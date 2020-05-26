/*
     Day 78: Leetcode 507. Perfect Number
     Time Spent: 11 mins
     
     Personal notes: edge cases
*/

class Solution {
    public boolean checkPerfectNumber(int num) {
             
        if(num==0){
            return false;
        }
        int sum=0;
        
        int i=1;
        while(sum<num && i<num){
            if(num%i==0){
                sum+=i;
            }
            i+=1;
        }
        
        if(sum==num){
            return true;
        }else{
            return false;
        }
    }
}
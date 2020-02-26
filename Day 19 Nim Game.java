/*
     Day 19: Leetcode 292. Nim Game
     Time Spent: 23 mins
     
     Personal notes: the divisible by 4 case makes sense
*/


class Solution {
    public boolean canWinNim(int n) {
        if(n<=3){
            return true;
        }
        if(n%4==0){
            return false;
        }
        /*
        if(n%5==0){
            return true;
        }
        */
        
        /*
        boolean two = n%2 ==0 ? false : true;
        boolean three = (n%3)%2==0 ? false : true;
        
        if(two ==true && three==true){
            return true;
        }
        else{
            return false;
        }
        */
        return true;
    }
}
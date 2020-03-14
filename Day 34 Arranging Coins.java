/*
     Day 34: Leetcode 441. Arranging Coins
     Time Spent: 10 mins
     
     Personal notes: 
     
*/



class Solution {
    public int arrangeCoins(int n) {
        int r=0;
        if(n<1){
            return 0;
        }
        
        
        while(n>0){
            n-=r;
            //System.out.println(n+"   r:"+r);
            if(n>0){
                r+=1;
            }
            else if(n==0){
                break;
            }
            else{
                r-=1;
            }
            
        }
         
        return r;
    }
}
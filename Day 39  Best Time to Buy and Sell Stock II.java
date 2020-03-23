/*
     Day 39: Leetcode 122. Best Time to Buy and Sell Stock II
     Time Spent: 15 mins
     
     Personal notes: After figuring out first iteration of this problem. This one was not that complicated.
     
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        if(prices.length==1){
            return 0;
        }
        int max_gain=0;
        // start price
        int prev=prices[0];
        
        int i=1;
        while(i<prices.length){
             // if increasing
            if(prices[i]-prev>0){
                max_gain+=prices[i]-prev;
            }
            //if decreasing
            else if(prices[i]-prev<0){
                // do nothing  
            } 
            
            prev=prices[i];
            i+=1;
            
            System.out.println(" **  max_gain :"+max_gain);
        }
        
        System.out.println("  max_gain :"+max_gain);
        return max_gain;
        
    }
}
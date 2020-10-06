/*
     Day 110: Leetcode  121. Best Time to Buy and Sell Stock

     Time Spent: 8 mins 
     
     Personal notes: Still remembered
*/


class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0 || prices.length==1){
            return 0;
        }
        int min=prices[0];
        int max=prices[0];
        int diff=0;
        int max_profit=0;
        for(int i=0;i<prices.length;i++){
            
            if(prices[i]-min>max_profit){
                max_profit=prices[i]-min;
            }
            
            if(prices[i]<min){
                min=prices[i];
            }
            
        }
        
        return max_profit;
    }
}

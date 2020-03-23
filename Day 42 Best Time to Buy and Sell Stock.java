/*
     Day 42: Leetcode 121. Best Time to Buy and Sell Stock
     Time Spent: 55 mins
     
     
	110 / 200 test cases passed with my method
     
     Personal notes: I over complicated it thinking about peaks. Just simply buy at start and see how stock varies
     
*/


class Solution {
    
     public int maxProfit(int[] prices) { // Kevin Naughton soln
         int max_gain=0;
         int min=Integer.MAX_VALUE;
         for(int i=0;i<prices.length;i++){
             if(prices[i]<min){
                 min=prices[i];
             }
             else{
                 max_gain=Math.max(prices[i]-min,max_gain);
             }
         }
         return max_gain;
     }
    
    public int maxProfitA(int[] prices) {
        
        if(prices.length==0){
            return 0;
        }
        if(prices.length==1){
            return 0;
        }
        int max_gain=prices[1]-prices[0];
        // start price
        int prev=prices[0];
        
        int profit=0;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        
        int i=1;
        while(i<prices.length){
             // if decreasing
            if(prices[i]-prev>0){
                high=Math.max(high,prices[i]);
                
            }
            //if increasing
            else if(prices[i]-prev<0){
                low=Math.min(low,prices[i]);
            } 
            if(low==Integer.MAX_VALUE || high==Integer.MIN_VALUE){
                
            }
            else{
                max_gain=Math.max(high-low, max_gain);
            }
            prev=prices[i];
            i+=1;
            
            
            System.out.println(" **  low: "+low+"  high: "+high+"  max_gain :"+max_gain);
        }
        
        if(high==Integer.MIN_VALUE){
            return 0;
        }
        if(low==Integer.MAX_VALUE){
            return prices[prices.length-1]-prices[0];
        }
        
        System.out.println("low: "+low+"  high: "+high);
        return max_gain;
        
    }
}
/*
     Day 91: Leetcode 188. Best Time to Buy and Sell Stock IV
     Time : 50 mins
     
     Personal notes: Intuition on buy and sell plus achieving efficiency
*/



class Solution {
    public int maxProfit(int k, int[] p) {
        if(p.length==0){
            return 0;
        }
        if(k==0){
            return 0;
        }
        
        if (k >= p.length / 2) return quickSolve(p); // part I didn't get
        
        //int fb=Integer.MAX_VALUE,sb=Integer.MAX_VALUE;
        //int fs=0,ss=0;
        int ss=0;
        
        int[][] arr = new int[k][2];
        
        for(int i=0;i<k;i++){
            arr[i][0]=100000; // buy
            arr[i][1]=0; // sell
        }
        
        int j=0;
        
        for(int i=0;i<p.length;i++){
            j=0;
            ss=0;
            while(j<k){ // k transactions
                arr[j][0]=Math.min(arr[j][0],p[i]-ss);
                arr[j][1]=Math.max(arr[j][1],p[i]-arr[j][0]);
                ss=Math.max(ss,arr[j][1]);
                //System.out.println("i: "+i+" j: "+j+"  b: "+arr[j][0]+" s: "+arr[j][1]+" ss: "+ss);
                j+=1;
            }
        }
        
        //System.out.println(arr[k-1][1]);
        return arr[k-1][1];
    }
    
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
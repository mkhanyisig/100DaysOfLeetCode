/*
     Day 96: Leetcode 198. House Robber
     Time Spent: 15 mins 
     
     Personal notes: starting condition
*/

class Solution {
    public int rob(int[] nums) {
        /*
        bottom up approach
        
        arr [prev, curr]
        
        */
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        
        int[] dp= new int[nums.length];
        
        dp[0]=nums[0];
        dp[1]=nums[1];
        
        dp[2]=Math.max(dp[0]+nums[2],nums[1]);
        
        int i=3;
        while(i<nums.length){
            dp[i]=Math.max(nums[i]+dp[i-2],nums[i]+dp[i-3]);
            i++;
        }
        
        return Math.max(dp[dp.length-1],dp[dp.length-2]);
        
    }
}
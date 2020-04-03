/*
     Day 51: Leetcode 198. House Robber
     Time Spent: 18 mins 
     
     Personal notes: DP houserobber repeat. did this on day 11. repeated to see if I remembered solution
*/


class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        
        if(nums.length==1){
            return nums[0];
        }
        
        if(nums.length==0){
            return 0;
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }        
        int i=2;
        dp[0]=nums[0];
        dp[1]=nums[1];
        while(i<=nums.length){
            if(i-3>=0){
                dp[i]=Math.max(nums[i]+dp[i-2],nums[i]+dp[i-3]);
            }else{
                dp[i]=nums[i]+dp[i-2];
            }
            
            i+=1;
            if(i==nums.length){
                i-=1;
                break;
            }
        }
        System.out.println(dp[i]+"   *   "+dp[i-1]);
        return Math.max(dp[i],dp[i-1]);
    }
    
}
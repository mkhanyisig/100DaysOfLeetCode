/*
     Day 96: Leetcode 213. House Robber II
     Time Spent: 50 mins 
     
     Personal notes: Was right about intuition that first and last houses need to be factored into starting conditions. Helper funtion needed
*/



class Solution {
    public int robA(int[] nums) { // 51 / 74 test cases passed.
        /*
        can cicle back
        
        */
        
        // add last house as tail
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length==3){
            return Math.max(nums[1],Math.max(nums[0],nums[2]));
        }
        if(nums.length==4){
            return Math.max(nums[0]+nums[2],nums[1]+nums[3]);
        }
        
        
        int[] dp= new int[nums.length];
        
        dp[0]=nums[nums.length-1]; // last element
        dp[1]=nums[0];
        dp[2]=Math.max(nums[1]+dp[0],dp[1]);
        
        int i=3;
        int j=2;
        while(i<dp.length ){
            dp[i]=Math.max(nums[j]+dp[i-2],nums[j]+dp[i-3]);
            i+=1;
            j+=1;
        }
        
        //dp[dp.length-1]=Math.max(dp[dp.length-2],nums[nums.length-1]+dp[dp.length-3]);
        System.out.println(dp[dp.length-1]+"     "+ dp[dp.length-2]);
        return Math.max(dp[dp.length-1],dp[dp.length-2]);
    }
    
    public int rob(int[] nums) {
    if(nums==null || nums.length==0)
        return 0; 
 
    if(nums.length==1)
        return nums[0];
 
    int max1 = robHelper(nums, 0, nums.length-2);
    int max2 = robHelper(nums, 1, nums.length-1);
 
    return Math.max(max1, max2);
	}
 
	public int robHelper(int[] nums, int i, int j){
		if(i==j){
			return nums[i];
		}
 
		int[] dp = new int[nums.length];
		dp[i]=nums[i];
		dp[i+1]=Math.max(nums[i+1], dp[i]);
 
		for(int k=i+2; k<=j; k++){
			dp[k]=Math.max(dp[k-1], dp[k-2]+nums[k]);    
		}
 
		return dp[j];
	}
}
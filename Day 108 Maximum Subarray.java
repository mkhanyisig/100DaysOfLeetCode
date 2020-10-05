/*
     Day 108: Leetcode  53. Maximum Subarray
     Time Spent: 11 mins 
     
     Personal notes: Edge cases and optimal code before testing

*/


class Solution {
    public int maxSubArray(int[] nums) {
        /*
        try out all subarrays and check sum
        update max sum
        */
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int max=Integer.MIN_VALUE;
        int sum;
        
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum>max){
                    max=sum;
                }
            }
        }
        
        // two pointer     
        
        return max;
        
    }
}
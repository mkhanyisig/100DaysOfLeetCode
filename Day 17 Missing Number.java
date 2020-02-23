/*
     Day 16: Leetcode 389. Find the Difference
     Time Spent: 7 mins
     
     Personal notes: pretty straightforward problem
*/

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1 && nums[0]==0){
            return 1;
        }
        
        for(int i=0;i<nums[nums.length-1];i++){
            if(nums[i]!=i){
                return i;
            }
        }
        
        return nums[nums.length-1]+1;
    }
}
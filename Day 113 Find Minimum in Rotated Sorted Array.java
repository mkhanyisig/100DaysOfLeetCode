/*
     Day 110: Leetcode  153. Find Minimum in Rotated Sorted Array

     Time Spent: 2 mins 
     
     Personal notes: very simple, basic property of sorted array
*/


class Solution {
    public int findMin(int[] nums) {
        int prev=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<prev){
                return nums[i];
            }
            prev=nums[i];
        }
        return nums[0];
    }
}
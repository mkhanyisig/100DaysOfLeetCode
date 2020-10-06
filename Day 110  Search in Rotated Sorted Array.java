/*
     Day 110: Leetcode  33. Search in Rotated Sorted Array

     Time Spent: 22 mins 
     
     Personal notes: logic for search
*/


class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }else{
                return -1;
            }
        }
           
        if(nums[nums.length-1]>=target){// start search from end
            System.out.println("end");
            int next=nums[nums.length-1];
            int i=nums.length-1;
            while(i>=0 && nums[i]<=next ){
                if(nums[i]==target){
                    return i;
                }
                next=nums[i];
                i-=1;
            }
        }
        if(nums[0]<=target){// start from beginning
            System.out.println("beginning");
            int prev=nums[0];
            int i=0;
            while(i<nums.length && nums[i]>=prev){
                if(nums[i]==target){
                    return i;
                }
                prev=nums[i];
                i+=1;
            }
            
        }
           
        return -1;
    }
}
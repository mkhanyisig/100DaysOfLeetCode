/*
     Day 19: Leetcode 704. Binary Search
     Time Spent: 40 mins
     
     Personal notes: This should not have taken me this long. Debugging terminating conditions took the most time 
*/



class Solution {
    public int search(int[] nums, int target) {
        int val =-1;
        if(nums.length==1){
            if(nums[0]==target){
                val=0;
            }
            return val;
        }
        int mid = 0;
        int l=0;
        int r=nums.length-1;
        while(l<r){
            if(nums[mid]==target){
                val=mid;
                break;
            }
            if(nums[r]<=target && r-l==1){ // value on right edge
                if(nums[r]==target){
                    val=r;
                }
                break;
            }
            if(nums[l]<=target && r-l==1){ // value on left edge
                if(nums[l]==target){
                    val=l;
                }
                break;
            }
            if(r-l==1){ // not found inbetween left and right edges, break
                break;
            }
            mid = l+(r-l)/2;
            System.out.println("mid :"+mid+" l:"+l+"  r: "+r);
            if(target>=nums[mid]){// right subtree
                l=mid;
            }
            else{ // left subtree
                r=mid-1;
            }
        }
 
        return val;
    }
}
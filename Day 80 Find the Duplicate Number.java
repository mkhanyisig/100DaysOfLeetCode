/*
     Day 78: Leetcode 287. Find the Duplicate Number
     Time Spent: 3 mins
     
     Personal notes: Believe it or not this is a medium problem
*/

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs= new HashSet<Integer>();
        
        for(int n: nums){
            if(!hs.contains(n)){
                hs.add(n);
            }else{
                return n;
            }
        }
        
        return nums[0];
    }
}
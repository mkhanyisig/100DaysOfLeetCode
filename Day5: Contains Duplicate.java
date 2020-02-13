/*
     Day 4: Leetcode 217. Contains Duplicate
     Time Spent: 15 mins
     
     Personal notes: What are advantages of using hashset over arraylist? Arraylist failed the final testcase and I thus had to switch to hashset
     
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // arraylist
        //ArrayList<Integer> arr = new ArrayList<Integer>();
        Set<Integer> arr    = new HashSet<Integer>();
        //System.out.println(nums.length);
        for(int i=0;i<nums.length;i++){
            if(!arr.add(nums[i])){
                return true;
            }    
            
        }
        
        return false;
    }
}

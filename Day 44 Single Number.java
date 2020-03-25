/*
     Day 39: Leetcode 136. Single Number
     Time Spent: 11 mins
     
     
     Personal notes: took me 5 mins to code soln, rest was debugging and reading documentation
     
*/



class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> h= new HashSet<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(h.contains(nums[i])){
                h.remove(nums[i]);
            }
            else{
                h.add(nums[i]);
            }
        }
        //ArrayList<Integer> n= h.keySet();
        Iterator iter = h.iterator();
        Integer i=(Integer)iter.next();
        
        return i.intValue();
    }
}
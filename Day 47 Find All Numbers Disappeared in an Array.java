/*
     Day 46: Leetcode 448. Find All Numbers Disappeared in an Array
     Time Spent: 31 mins
     
     
     Personal notes: Most time spent debugging long runtime, HashSet (O(1))vs ArrayList (O(n))contains methods runtime difference
     
*/



class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) { // Method A : time limit exceeded
        //List<Integer> l= new LinkedList<>();
        List<Integer> res= new LinkedList<>();
        //int max=0;
        
        
        //ArrayList<Integer> l= new ArrayList<Integer>();
        //Collections.addAll(l, nums);
        List<Integer> l = new ArrayList<Integer>(nums.length);
        for (int i : nums){
            l.add(i);
        }
        
        for(int i=1; i<=nums.length;i++){
            if(!l.contains(i)){
                res.add(i);
            }
        }
        
        return res;
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {  // HashSet instead of arraylist
        //List<Integer> l= new LinkedList<>();
        List<Integer> res= new LinkedList<>();
        //int max=0;
        HashSet<Integer> hs = new HashSet<>();
        
        //ArrayList<Integer> l= new ArrayList<Integer>();
        //Collections.addAll(l, nums);
        List<Integer> l = new ArrayList<Integer>(nums.length);
        for (int i : nums){
            hs.add(i);
        }
        
        for(int i=1; i<=nums.length;i++){
            if(!hs.contains(i)){
                res.add(i);
            }
        }
        
        return res;
    }
    
}
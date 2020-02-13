/*
     Day 4: Leetcode 217. Contains Duplicate
     Time Spent: 77 mins
     
     Personal notes: Made deadly mistake of misnaming variable and that delayed my debugging, took very long to catch and fix
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> arr    = new HashMap<Integer,Integer>();
        ArrayList<Integer> intarr = new ArrayList<Integer>(); // repeated indices
        //Set<Integer> hs    = new HashSet<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(arr.containsKey(nums[i])){
                if(!intarr.contains(arr.get(nums[i]))){
                    
                }
                else{
                    intarr.add(i);    
                }
            }  
            else{
                arr.put(nums[i],i);
                intarr.add(i);
                //hs.add(nums[i]);
            }
        }
        System.out.println(" intarr size: "+intarr.size());
        for(int i=0;i<intarr.size();i++){
            for(int j=0;j<intarr.size();j++){
                if(nums[i]==nums[j] && Math.abs(i-j)<=k && i!=j){
                    System.out.println(nums[i]+"   k:"+k+"  diff: "+Math.abs(i-j) );
                    return true;
                }
            }
        }
        return false;                             
    } 
}

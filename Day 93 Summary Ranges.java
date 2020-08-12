/*
     Day 93: Leetcode 228. Summary Ranges
     Time Spent: 90 mins 
     
     Personal notes: Took me way longer than should have if I took some time to think about it. Map out brute force intuition then code it
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary= new LinkedList<String>();
        
        if(nums.length==0){
            return summary;
        }
        if(nums.length==1){
            summary.add(Integer.toString(nums[0]));
            return summary;
        }
        
        int i=1;
        int l=0;
        while(i<nums.length){
            //System.out.println("**");
            if(nums[i]-nums[i-1]==1){
                if(i==nums.length-1){
                    summary.add(nums[l]+"->"+nums[i]); 
                }
            }
            else{
                System.out.println("diff => "+(nums[i]-nums[i-1]));
                if(nums[i-1]==nums[l]){
                    summary.add(nums[l]+"");
                    
                }else{
                    summary.add(nums[l]+"->"+nums[i-1]);
                } 
                if(i==nums.length-1){
                    summary.add(nums[i]+"");
                }
                
                l=i;         
            }  
            i+=1;
        }
        return summary;
        
    }
}
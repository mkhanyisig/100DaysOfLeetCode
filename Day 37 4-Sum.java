/*
     Day 35: Leetcode 18. 4Sum
     Time Spent: 48 mins
     
     Personal notes: Brute force solution easy. Tried to optimize for O(n^3) solution which also eliminates duplicates
     
*/



class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hash = new HashSet<List<Integer>>();
        /*
        Pseudocode
        
        sort array
        
        double for loop
            zoom in for each iterartion l>><<r
                check if sum mathces target
                    if unique combination
                        add to result
         p  l  r              q
        [0, 1, 2, 3, 4, 5, 7, 9]
        
        
        
        */
        
        Arrays.sort(nums);
        
        int insum=0;
        for(int p=0;p<=nums.length-4;p++){
            for(int q=nums.length-1;q>p;q--){
                int presum = nums[p]+nums[q];
                int l=p+1;
                int r=q-1;
                //System.out.println("p: "+p+ " q:"+q+" l:"+l+" r:"+r);
                while(l<r){
                    //System.out.println("p: "+nums[p]+ " q:"+nums[q]+" l:"+nums[l]+" r:"+nums[r]+ "  insum:"+insum);
                    insum=presum+nums[l]+nums[r];
                    if(insum==target){
                        List<Integer> lst= new ArrayList<Integer>();
                        // unique elements
                        HashSet<Integer> hs = new HashSet<Integer>();
                        hs.add(p);
                        hs.add(q);
                        hs.add(r);
                        hs.add(l);
                        
                        // if all unique elements
                        if(hs.size()==4){
                            lst.add(nums[p]);
                            lst.add(nums[l]);
                            lst.add(nums[r]);
                            lst.add(nums[q]);
                            if(!hash.contains(lst)){
                                result.add(lst);
                                hash.add(lst);
                            }
                            
                        }
                        
                        r-=1;
                        l+=1;
                        
                        
                    }
                    else if(insum>target){
                        r-=1;;
                    }
                    else{
                        l+=1;
                    }
                    
                }
                
            }
        }
        return result;
    }
}
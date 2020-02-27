/*
     Day 20: Leetcode 350. Intersection of Two Arrays II
     Time Spent: 31 mins
     
     Personal notes: same as what I did before, but this time duplicates allowed
*/



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> na = new HashSet<Integer>(); 
        HashSet<Integer> nb = new HashSet<Integer>(); 
        //ArrayList<Integer> la = Arrays.asList(nums1);
        
        //List<Integer> lb = new ArrayList<Integer>(Arrays.asList(nums2));
        ArrayList<Integer> inter = new ArrayList<Integer>();
        ArrayList<Integer> la = new ArrayList<Integer>();
        ArrayList<Integer> lb = new ArrayList<Integer>();
        // build hashset
        for(int i=0;i<nums1.length;i++){
            na.add(nums1[i]);
            la.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            nb.add(nums2[i]);
            lb.add(nums2[i]);
        }
        
        /* // unique values in intersection *** first option ***
        System.out.println("Iterating over hashset 1:"); 
        Iterator<Integer> i = na.iterator(); 
        int k=0;
        while (i.hasNext()) {
            k=i.next();
            System.out.println(k); 
            if(nb.contains(k)){
                inter.add(k);
            }
        }
        */
        
        for(int i=0;i<lb.size();i++){
            if(la.contains(lb.get(i))){
                inter.add(lb.get(i));
                // remove to avoid duplicates
                la.remove(lb.get(i));
            }
        }
        
        
        int[] result = new int[inter.size()];
        for(int j=0;j<inter.size();j++){
            result[j]=inter.get(j).intValue();
        }
        return result;
        
        
        
    }
}
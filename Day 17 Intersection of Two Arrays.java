/*
     Day 17: Leetcode 349. Intersection of Two Arrays
     Time Spent: 17 mins
     
     Personal notes: pretty straightforward problem, HashSet
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // two hashmaps. Check if contains then add to intersection array
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        
        HashSet<Integer> ha = new HashSet();
        HashSet<Integer> hb = new HashSet();
        
        for(int i=0;i<nums1.length;i++){
            ha.add(nums1[i]);
        }
        
        for(int j=0;j<nums2.length;j++){
            hb.add(nums2[j]);
        }
        
        for(Integer c:ha){
            if(hb.contains(c)){
                arrli.add(c);
            }
        }
        //return arrli.toArray();
        int[] result = new int[arrli.size()];
		for (int i = 0; i < arrli.size(); i++) {
			result[i] = arrli.get(i).intValue();
		}
        return result;
    }
}
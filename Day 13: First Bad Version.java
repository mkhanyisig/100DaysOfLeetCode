/*
     Day 13: Leetcode 278. First Bad Version
     Time Spent: 23 mins
     
     Personal notes: Iterative solutions fails fr very big numbers, so go with binary search solution
*/


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        System.out.println(" num :"+n);
        
        int l=1;
        int i=n;
        // binary search
         while(l<i){
            int mid=l+(i-l)/2;
            if(isBadVersion(mid)){ // right side BS
                // do nothing
                i=mid;
            }
            else{ // left side BS
                l=mid+1;
            }
            
        }
        
        
        return l;
        
      
    }
}

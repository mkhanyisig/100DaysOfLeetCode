/*
     Day 46: rainwater
     Time Spent: 59 mins
     
     
     Personal notes: This suprisingly took me longer than I expected
     
*/



class Solution {
    public int trap(int[] height) {
        System.out.println("length :"+height.length);
        if(height.length==0){
            return 0;
        }
        int prev=height[0];
        int i=0;
        int total=0;
        
        int st=height[0];
        int st_idx =0;
        int end=height[0];
        
        // DP soln
        int[] arr= new int[height.length];
        
        while(i<height.length){
            // max water trapped between i and next highest/equivalent
                // if no next highest, move to next i
            
            // find next highest
            if(height[i]>=st){ // calculate water inbetween
                System.out.println(" calc water   :"+i+"  st_idx:"+st_idx);
                for(int j=st_idx;j<i;j++){
                    System.out.println("st_idx : "+st_idx+"  j: "+j);
                    total+=height[st_idx]-height[j];
                }
                System.out.println("**  total :"+total);
                st_idx=i;
                st=height[i];
                i+=1;
            }else if(i==height.length-1 && height[i]<st){// reached end, recurse back to i+1
                System.out.println("recurse  :"+i+"  st_idx:"+st_idx);
                i=st_idx+1;
                st=height[i];
                i+=1;
            }else{// move forward
                System.out.println("move forward   :"+i+"  st_idx:"+st_idx);
                i+=1;   
            }
        }
        return total;
    }
}
/*
     Day 46: Leetcode 42. Trapping Rain Water
     Time Spent: 99 mins
     
     
     Personal notes: Getting through cases
     
*/



class Solution { 
    public int trap(int[] height) { // attempt A: mine     (230 / 315 test cases passed.)
    
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
                if(st_idx-1>=0 && height[i]<=height[st_idx-1]){
                    System.out.println("## end st");
                    //st_idx-=1;
                    st=height[i];
                }
                
                for(int j=st_idx;j<i;j++){
                    System.out.println("st_idx : "+st_idx+"  j: "+j);
                    total+=st-height[j];
                }
                System.out.println("**  total :"+total);
                st_idx=i;
                st=height[i];
                i+=1;
            }else if(i==height.length-1 && height[i]<st){// reached end, recurse back to i+1
                System.out.println("recurse  :"+i+"  st_idx:"+st_idx);
                i=st_idx+1;
                st_idx=i;
                st=height[i];
                i+=1;
            }else{// move forward
                System.out.println("move forward   :"+i+"  st_idx:"+st_idx);
                i+=1;   
            }
        }
        return total;
    }
    
    // other soln
    public int trapB(int[] heights) {
        /*int total=0;
        
        for(int i=0;i<height.length;i++){
            int lmx= getMax(height,0,i);
            int rmx=getMax(height,i,height.length-1);
            total+=Math.min(lmx,rmx)-height[i];
            
        }
        
        return total;
        */
        
        int result = 0, maxleft = 0, maxright = 0;
		int size = heights.length;
		for(int i=1;i<size-1;i++){
			maxleft = 0; maxright = 0;
			for(int j=i;j>=0;j--){
				maxleft = Math.max(maxleft, heights[j]);
			}
			for(int j=i;j<=size-1;j++){
				maxright = Math.max(maxright, heights[j]);
			}
            System.out.println(maxleft+"  "+maxright);
			result += Math.min(maxleft, maxright) - heights[i];
		}
		
		return result;
    }
    
    public int trapC(int[] height) {
        int left = 0, right = height.length-1;
        int maxleft = 0, maxright = 0;
        int result = 0;
        while(left <= right){
            if(height[left] < height[right]){
                if(height[left]>=maxleft) maxleft = height[left];
                else result += maxleft - height[left];
                left++;
            }
            else{
                if(height[right]>=maxright) maxright = height[right];
                else result+=maxright-height[right];
                right--;
            }
        }
        return result;
    }   
}
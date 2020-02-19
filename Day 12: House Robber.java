/*
     Day 12: Leetcode 198. House Robber
     Time Spent: 127 mins
     
     Personal notes: Dynamic programming question took a while handling cases
     bottom up processing
*/


class Solution {
    public int rob(int[] nums) {
        int sum=0;
        // could have just simply called the max function
        int odd=0;
        int even=0;
        
        if(nums.length==1){
            return nums[0];
        }
        
        if(nums.length==0){
            return 0;
        }
        
        int p=0;
        //
        even+=nums[p];
        while(p<nums.length){
            if(p+3<nums.length){
                if(p+4<nums.length && nums[p+2]+nums[p+4]>nums[p+3]){
                    if(p+5<nums.length && nums[p+4]<nums[p+5]){
                        if(p+6<nums.length && nums[p+6]+nums[p+4]>nums[p+5]){
                            System.out.println("p+5: even :"+nums[p+2]+" and "+nums[p+5]);  
                        even+=nums[p+2]+nums[p+4]+nums[p+6];
                        p+=6;
                        }
                        else{
                            System.out.println("p+5: even :"+nums[p+2]+" and "+nums[p+5]);  
                        even+=nums[p+2]+nums[p+5];
                        p+=5;
                        }
                        
                    }
                    else{
                        System.out.println("p+4: even :"+nums[p+2]+" and "+nums[p+4]);  
                        even+=nums[p+2]+nums[p+4];
                        p+=4;
                    }
                    
                }
                else if(p+4<nums.length && nums[p+2]+nums[p+4]==nums[p+3]){
                    System.out.println("p+4: even :"+nums[p+3]);                                         even+=nums[p+3];
                    p+=3;
                }
                else if(nums[p+2]>nums[p+3]){
                    System.out.println("p+3: 2>3 even :"+nums[p+2]);
                    even+=nums[p+2];
                    p+=2;
                }
                else if(nums[p+2]==nums[p+3]){
                    System.out.println("p+3: 2==3 even :"+nums[p+2]);
                    even+=nums[p+2];
                    p+=2;
                }
                else{
                    System.out.println("p+3 3>2 even :"+nums[p+3]);
                    even+=nums[p+3];
                    p+=3;
                }
            }
            else if(p+2<=nums.length-1){
                System.out.println("p+2  even :"+nums[p+2]);
                even+=nums[p+2];
                p+=2;
            }
            else{
                // do nothing
                System.out.println("nothing : even   *"+nums[p]);
                p+=2;
            }
            
        }
        
        p=1;
        odd+=nums[p];
        while(p<nums.length){
            if(p+3<nums.length){
                if(p+4<nums.length && nums[p+2]+nums[p+4]>nums[p+3]){
                    if(p+5<nums.length && nums[p+4]<nums[p+5]){
                        if(p+6<nums.length && nums[p+6]+nums[p+4]>nums[p+5]){
                            System.out.println("p+6: odd :"+nums[p+2]+", "+nums[p+4]+" and "+nums[p+6]);  
                        odd+=nums[p+2]+nums[p+4]+nums[p+6];
                        p+=6;
                        }
                        else{
                            System.out.println("p+5: odd :"+nums[p+2]+" and "+nums[p+5]);  
                        odd+=nums[p+2]+nums[p+5];
                        p+=5;
                        }
                    }
                    else{
                        System.out.println("p+4: odd :"+nums[p+2]+" and "+nums[p+4]); 
                        odd+=nums[p+2]+nums[p+4];
                        p+=4;
                    }
                }
                else if(p+4<nums.length && nums[p+2]+nums[p+4]==nums[p+3]){
                    System.out.println("p+4: odd :"+nums[p+3]);                                         odd+=nums[p+3];
                    p+=3;
                }
                else if(nums[p+2]>nums[p+3]){
                    System.out.println("p+3: 2>3 odd :"+nums[p+2]);
                    odd+=nums[p+2];
                    p+=2;
                }        
                else{
                    System.out.println("p+3: 3>2 odd :"+nums[p+3]);
                    odd+=nums[p+3];
                    p+=3;
                }
            }
            else if(p+2<=nums.length-1){
                System.out.println("p+2: odd :"+nums[p+2]);
                odd+=nums[p+2];
                p+=2;
            }
            else{
                // do nothing
                
                System.out.println("nothing : odd    *"+nums[p]);
                p+=2;
            }
        }
        System.out.println("even: "+even+"   odd: "+odd);
        if(even>odd){
            return even;
        }
        else{
            return odd;
        }
    }
}


// Kevin Naughton || Geeks for Geeks solution

class Solution{
	public int rob(int[] hval) {
		n=hval.length;
		if (n == 0) 
        	return 0; 
        if (n == 1) 
            return hval[0]; 
        if (n == 2) 
            return Math.max(hval[0], hval[1]); 
   
        // dp[i] represent the maximum value stolen 
        // so far after reaching house i. 
        int[] dp = new int[n]; 
   
        // Initialize the dp[0] and dp[1] 
        dp[0] = hval[0]; 
        dp[1] = Math.max(hval[0], hval[1]); 
   
        // Fill remaining positions 
        for (int i = 2; i<n; i++) 
            dp[i] = Math.max(hval[i]+dp[i-2], dp[i-1]); 
   
        return dp[n-1]; 
	
	}

}

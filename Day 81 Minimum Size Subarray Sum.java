/*
     Day 81: Leetcode 209. Minimum Size Subarray Sum
     Time Spent: 25 mins
     
     Personal notes: Couldn't get an optimal solution to fit within timeframe. Time complexity issue, otherwise all test cases passed
*/




class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // sliding window problem
        // start from 1 to n
        
        int[] sub_arr;
        
        int j=0;
        int sum;
        while(j<=nums.length){
            for(int i=0;i<nums.length;i++){
                
                // slide window
                if(i+j<=nums.length){
                    sub_arr=Arrays.copyOfRange(nums,i,i+j);
                    // add all elements
                    sum=0;
                    for(int k=0;k<sub_arr.length;k++){
                        sum+=sub_arr[k];
                    }
                    if(sum>=s){
                        //System.out.println(" over :"+i+"  "+j+"  =>"+Arrays.toString(sub_arr));
                        return j;
                    }
                }
                else{
                    sub_arr=Arrays.copyOfRange(nums,i,nums.length-1);
                    // add all elements
                    sum=0;
                    for(int k=0;k<sub_arr.length;k++){
                        sum+=sub_arr[k];
                    }
                    if(sum>=s){
                        //System.out.println(" over :"+i+"  "+j+"  =>"+Arrays.toString(sub_arr));
                        return j;
                    }
                }
            }
            j+=1;
        }
        
        return 0;
    }
}
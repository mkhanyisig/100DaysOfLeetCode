/*
     Day 22: Leetcode 392. Is Subsequence
     Time Spent: 18 mins
     
     Personal notes: Logic around solution mostly
*/




class Solution {
    public boolean isSubsequence(String s, String t) {
        System.out.println("t length: "+t.length()+"   s length:"+s.length());
        // by default
        if(s.length()==0){
            return true;
        }
        
        if(s.length()>t.length()){
            return false;
        }
        int target=s.length();
        int ptr=0;
        int i=0;
        while(i < t.length()){
            
            if(s.charAt(ptr)==t.charAt(i) && ptr<=target-1){
                System.out.println("t: "+t.charAt(i)+"   s:"+s.charAt(ptr));
                ptr+=1;
                if(ptr==target){
                    return true;
                }
            }
            i+=1;
            
        }
        System.out.println("ptr"+ptr+"   target:"+target);
        if(ptr==target){
            return true;
        }
        return false;
    }
}
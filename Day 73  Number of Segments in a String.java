/*
     Day 73: Leetcode 434. Number of Segments in a String
     Time Spent: 18 mins 
     
     Personal notes: Debugging edge cases nuances took a while
*/


class Solution {
    public int countSegments(String s) {
        int n=0;
        
        int st=0;
        int e=0;
        boolean word=false;
        
        while(e<s.length()){
            if(s.charAt(e)==' '){
                if(e-st>=1 && word==true){
                    n+=1;
                }
                word=false;
                st=e;
            }
            else{
                word=true;
            }
            e+=1;
        }
        if(e-st>0 && word==true){
                System.out.println("last");
             n+=1;
        }
        return n;
    }
}
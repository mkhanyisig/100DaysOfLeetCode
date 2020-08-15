/*
     Day 94: Leetcode 520. Detect Capital
     Time : 17 mins
     
     Personal notes: Should have taken me less time
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        // check all cases
        // else return false
        
        if(word.length()==0){
            return true;
        }
        
        char[] arr=word.toCharArray();
        
        //all caps
        boolean caps=true;
        // all lower
        boolean lower=true;
        // first cap
        boolean fcap=false;
        if(word.charAt(0)==Character.toUpperCase(word.charAt(0))){
            fcap=true;
        }
           
        for(char c:arr){
            if(c!=Character.toUpperCase(c)){
                caps=false;
            }
            if(c!=Character.toLowerCase(c)){
                lower=false;
            }
        }
        
        for(char c:Arrays.copyOfRange(arr,1,arr.length)){
             System.out.println(c);
            if(c!=Character.toLowerCase(c)){
               
                fcap=false;
            }
            
        }
        
        System.out.println("all caps: "+caps+"  all lower: "+lower+"  fcap: "+fcap);
        if(caps){
            return true;
        }
        if(lower){
            return true;
        }
        if(fcap){
            return true;
        }
        
        return false;
    }
}
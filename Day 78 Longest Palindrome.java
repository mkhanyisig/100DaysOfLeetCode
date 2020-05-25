/*
     Day 78: Leetcode 409. Longest Palindrome
     Time Spent: 19 mins
     
     Personal notes: edge cases
*/


class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        // count all pairs
        HashMap<Character, Integer> map= new HashMap<Character,Integer>();
        char c;
        // 
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int ret=0;
        int unit=0;
        for ( Character ch : map.keySet() ) {
            if(map.get(ch)%2==0){
                ret+=map.get(ch);
            }else if(map.get(ch)>1){
                ret+=map.get(ch)-1;
                unit+=1;
            }else{
                unit+=1;
            }
        }
        
        if(unit>0){
            ret+=1;
        }
        if(map.size()==1){
            for ( Character ch : map.keySet() ){
                return map.get(ch);
            }
        }
        return ret;
    }
}
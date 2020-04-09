/*
     Day 59 : Leetcode 387. First Unique Character in a String
     Time Spent: 10 mins 
     
     Personal notes: 
*/


class Solution {
    public int firstUniqChar(String s) {
        /*
            - build map of word count
            
            - loop through word and return if count==1
        
        */
        
        HashMap<Character,Integer> map= new HashMap<>();
        char[] carr=s.toCharArray();
        
        for(Character c:carr){
            map.put(c,map.getOrDefault(c, 0)+1 );
        }
        
        for(int i=0;i<carr.length;i++){
            if(map.get(carr[i])==1){
                  return i;  
            }
        }    
        return -1;
    }
}
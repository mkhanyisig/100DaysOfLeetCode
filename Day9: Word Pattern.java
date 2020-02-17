/*
     Day 9: Leetcode 290. Word Pattern
     
     Personal notes: Knew this involved mapping in some sort to check K-V pairs
*/


class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        
        if(words.length != pattern.length()){
            return false;
        }
        char curr;
        HashMap<Character,String> map= new HashMap();
        for(int i=0;i<words.length;i++){
            curr=pattern.charAt(i);
            if(map.containsKey(curr)){
                if(!map.get(curr).equals(words[i])){
                    return false;
                } 
            }
            else{
                if(map.containsValue(words[i])){
                    return false;
                }
                map.put(curr,words[i]);
                
            }
        }
        
        return true;
    }
}

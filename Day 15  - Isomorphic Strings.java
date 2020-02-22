/*
     Day 15: Leetcode 205. Isomorphic Strings
     Time Spent: 20 mins
     
     Personal notes: hash map data structure and how it works
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            // update map
            if(map.containsKey(s.charAt(i))==false){
                if(map.containsValue(t.charAt(i))==false){
                    map.put(s.charAt(i),t.charAt(i));
                }
                else{
                    System.out.println("value contained");
                    return false;
                }
                
            }
            else{// value already contained
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    System.out.println("not contained+ not equal map");
                    return false;
                }
                // else{
                //     System.out.println("not contained");
                //     return false;
                // }
            }
            
            // check if characters match
            if(map.get(s.charAt(i))!=t.charAt(i)){
                    System.out.println("not equal map");
                    return false;
            }
        }
        return true;
    }
}
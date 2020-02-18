/*
     Day 11: Leetcode 242. Valid Anagram
     Time Spent: 22 mins
     
     Personal notes: Map crashed for last testcase for you just for-loop through all the keys. Still does not make sense
*/



class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        System.out.println("S length :"+s.length()+"   T length: "+t.length());
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>(); 
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>(); 
        
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        
        // build maps
        for (char c : sarr) { 
            if (mapS.containsKey(c)) { // character already present
                mapS.put(c, mapS.get(c) + 1); 
            } 
            else { 
                // character not present
                mapS.put(c, 1); 
            } 
        } 
        
        for (char c : tarr) { 
            if (mapT.containsKey(c)) { // character already present
                mapT.put(c, mapT.get(c) + 1); 
            } 
            else { 
                // character not present
                mapT.put(c, 1); 
            } 
        } 
        System.out.println("Map size S :"+mapS.size()+"   Map size T "+mapT.size());
        /* // this breaks
        for(Character c: mapS.keySet()){
            if(mapS.get(c)!=mapT.get(c)){
                System.out.println(mapS.get(c)+"    "+mapT.get(c));
                return false;
            }
        }
        */
        
        return mapS.equals(mapT);
    }
}
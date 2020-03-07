/*
     Day 28: Leetcode 383. Ransom Note
     Time Spent: 18 mins
     
     Personal notes: 
     
*/


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length()){
            return false;
        }
        // build magazine character arraylist
        ArrayList<Character> mchars = new ArrayList<Character>();
        for (Character c : magazine.toCharArray()) {
          mchars.add(c);
        }
        // build ransomnote
        ArrayList<Character> rchars = new ArrayList<Character>();
        for (Character c : ransomNote.toCharArray()) {
          rchars.add(c);
        }
        
        for(Character c: rchars){
            System.out.println(c);
            if(mchars.contains(c)){
                mchars.remove(c);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
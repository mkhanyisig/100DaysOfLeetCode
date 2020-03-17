/*
     Day 36: Leetcode 125. Valid Palindrome
     Time Spent: 18 mins
     
     Personal notes: Comparing characters took me the longest time, otherwise easy problem
     
*/

class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^A-Za-z0-9]", ""); ;
        
        for(int i=0;i<s.length();i++){
           char c= Character.toLowerCase(s.charAt(i));
            char b=  Character.toLowerCase(s.charAt(s.length()-i-1));
            System.out.println(c+"   "+b);
            if(Character.compare(c, b) != 0){
                return false;
            }
            
        }
        return true;
    }
}
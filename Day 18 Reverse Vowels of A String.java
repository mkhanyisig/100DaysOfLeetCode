/*
     Day 17: Leetcode 345. Reverse Vowels of a String
     Time Spent: 25 mins
     
     Personal notes: pretty straightforward problem, reversing an array and tracking indices
*/


class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> chars = new ArrayList<Character>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        
        for(int i=0;i<s.length();i++){
            char ch = Character.toLowerCase(s.charAt(i));

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
                chars.add(s.charAt(i));
                indexes.add(i);
            }
        }
        //System.out.println(" vowels :"+Arrays.toString(chars.toArray()));
        //System.out.println(" indexes : "+Arrays.toString(indexes.toArray()));
        
        char[] str = s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            str[i]=s.charAt(i);
        }
        
        //System.out.println(" string :"+Arrays.toString(str));
        
        Collections.reverse(indexes);
        for(int i=0;i<chars.size();i++){
            //System.out.println(" string modified :"+Arrays.toString(str));
            str[indexes.get(i)]=chars.get(i);
        }
        //System.out.println(" string modified :"+Arrays.toString(str));
        
        String result="";
        for(int i=0;i<str.length;i++){
            result+=str[i];
        }
    
        return result;
    }
}
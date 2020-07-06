/*
     Day 87: Leetcode 127. Word Ladder
     Time : 58 mins
     
     Personal notes: Was a bit rusty on BFS. Had right idea about preprocessing and BFS, got stuck on while loop and solving problem step
     
*/


class Solution {
    
    public class Pair{
        String word;
        List<String> paths;
        
        public Pair(String w,List<String> p){
            this.word=w;
            this.paths=0
        }
    }
    
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        BFS approach
        - level order traversal
        - hashset to keep track of which words used
        
        start with begin word
        - add paths
        
        
        */
        
        HashSet<String> seen= new HashSet<String>();
        
        HashMap<String, List<String>> map=new HashMap<String, List<String>>();
        
        // build map of related words
        for(String word:wordList){
            String w=word;
            
            List<String> val=new LinkedList<String>();
            
            for(String n:wordList){
                int diff=0;
                for(int i=0;i<word.length();i++){
                    if(word.charAt(i)!=n.charAt(i)){
                        diff+=1;
                    }
                }
                if(diff==1){
                    val.add(n)
                }
            }    
            
            map.put(word,val);
        }  
        
        Queue<Pair> q= new LinkedList<Pair>();
        
        q.add(new Pair(word,map.get(word)));
        
        
        int res=0;
        boolean found = false;
        while(q.size()>0){
            Pair p=q.poll();
            
            // add all child nodes at level
            
            // 
           
        }
        
    }
}
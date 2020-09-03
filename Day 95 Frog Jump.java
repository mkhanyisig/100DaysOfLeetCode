/*
     Day 94: Leetcode 403. Frog Jump
     Time : 90 mins
     
     Personal notes: Need more DP practice. I went in a very hard direction. More practice
*/


class Solution {
    public boolean canCrossA(int[] s) {
        /*
            - try to optimize jump length & also ensure can reach next
            - DFS explore all options (recursive backtracking algorithm)
            - before each jump, check stones that can be reached
        */
        
        if(s.length<=1){
            return true;
        }
        
        int pos=0;
        int jump_len=0;
        int j=0;
        
        while(pos<s.length){
            System.out.println("Position: "+pos+"  Value: "+s[pos]+"  Jump length: "+jump_len);
            // check stones that can be reached
            ArrayList<Integer> reachable= new ArrayList<Integer>();
            for(int i=pos+1;i<s.length;i++){
                if(Math.abs(s[pos]-s[i])==jump_len || Math.abs(s[pos]-s[i])==jump_len+1 || Math.abs(s[pos]-s[i])==jump_len-1){
                    reachable.add(i);
                }
            }
            System.out.println("reachable list: ");
            reachable.forEach(r ->{
                System.out.println(r+"   => "+s[r]);
            });
            
            if(reachable.size()==0){
                return false;
            }
            
            // find the longest jump possible
            for(Integer n:reachable){
                j=s[n]-s[pos];
                System.out.println("j :"+j+"  value: "+s[n]);
                // reach the farthest
                if(n>pos){   
                    if(jump_len<j){
                        pos=n;
                        jump_len=j;
                    }
                }
                    
            }
            
        }   
        
        return true;
    }
     // Kevin Naughton
     public boolean canCross(int[] s) {
         for(int i=3;i<s.length;i++){
             if(s[i]>s[i-1]*2){
                 return false;
             }
         }
         
         
         HashSet<Integer> hs= new HashSet<>(); // stone positions
         for(int i:s){
             hs.add(i);
         }
         
         int lastStone=s[s.length-1];
         Stack<Integer> positions=new Stack<>();
         Stack<Integer> jumps=new Stack<>();
         // intial conditions
         positions.add(0);
         jumps.add(0);
         
         while(!positions.isEmpty()){
             int position=positions.pop();
             int jump_len=jumps.pop();
             //System.out.println("pos: "+position+"  jump length :"+jump_len);
             
             for(int i=jump_len-1;i<=jump_len+1;i++){// range of jump values
                 if(i<=0){// don't want to go back
                     continue;
                 }
                 
                 int nextPos=position+i;
                 //System.out.println("next position: "+nextPos);
                 if(nextPos==lastStone){// 
                     return true;
                 }else if(hs.contains(nextPos)){
                     //System.out.println("next position: "+nextPos+" jump_len: "+i);
                     positions.add(nextPos);
                     jumps.add(i);
                 }
             }
         }
         return false;
     }
}


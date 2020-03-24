/*
     Day 39: Leetcode 455. Assign Cookies
     Time Spent: 29 mins
     
     18 / 21 test cases passed.
     
     Personal notes: error somewhere
     
*/



class Solution {
    public int findContentChildrenA(int[] g, int[] s) {
        // greedy algorithm
        int num=0;
        int chi =0; 
        int cook=0;
        
        Arrays.sort(g); 
        Arrays.sort(s); 
        
        System.out.println(g.length+"    "+s.length);
        
        if(g.length==0 || s.length==0){
            return num;
        }
        
        // build cookie queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<s.length;i++){
                q.add(s[i]);
        }
        int child_idx=0;
        while(q.size()>0){
            // assign cookies to each child
            chi=g[child_idx];
            
            while(chi>0){
                chi-=q.poll();
                if(q.size()==0){
                    break;
                }
            }
            
            child_idx+=1;
            if(q.size()>=0 && chi<=0){
                num+=1;
            }
            if(child_idx>g.length-1){
                break;
            }
        }
        return num;
    }
    
    // greedy solution 2
    public int findContentChildren(int[] g, int[] s) {
        // greedy algorithm
        int num=0;
        int gp =0; 
        int sp=0;
        
        Arrays.sort(g); 
        Arrays.sort(s); 
        
        System.out.println(g.length+"    "+s.length);
        
        if(g.length==0 || s.length==0){
            return num;
        }
        
        while (gp < g.length && sp < s.length){
                if (s[sp] >= g[gp])
                {
                    sp++;
                    gp++;
                    num++;
                }
                else
                {
                    sp++;
                }
            }
        
        
        return num;
    }
}
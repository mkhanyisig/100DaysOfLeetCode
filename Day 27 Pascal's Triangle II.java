/*
     Day 28: Leetcode 383. Ransom Note
     Time Spent: 14 mins
     
     Personal notes: Bottom up approach
     
*/



class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0){
            //return ;
        }
        int[] prev=new int[1];
        prev[0]=1;
        int[] next=new int[1];
        next[0]=1;
        int row=0;
        while(row<rowIndex){
            next= new int[prev.length+1];
            next[0]=1;
            next[next.length-1]=1;
            
            for(int i=0;i<prev.length-1;i++){
                next[i+1]=prev[i]+prev[i+1];
            }
            prev=next;
            row+=1;
        }
        List<Integer> l= new ArrayList<Integer>();
        for(int i:next){
            l.add(new Integer(i));
        }
        return l;
    }
}
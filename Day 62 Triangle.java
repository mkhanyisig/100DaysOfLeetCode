/*
     Day 63 : Leetcode 120. Triangle
     Time Spent: 82 mins 
     
     Personal notes: Took a while to build a dp soln
*/



class Solution {
    // graph 
    
    
    public int minimumTotalF(List<List<Integer>> arr) {
        
        int sum=0;
        if(arr.size()==0){
            return sum;
        }
        if(arr.size()==1){
            return arr.get(0).get(0);
        }
        if(arr.size()==2){
            return Math.min(arr.get(0).get(0),arr.get(1).get(0));
        }
        
        int i=0;
        sum=arr.get(0).get(0);
        i+=1;
        while(i<arr.size()){
            System.out.println(i);
            sum=arr.get(i-1).get(0)+sum;
            System.out.println("gets here");
            for(int j=1;i<arr.get(i-1).size()-1;j++){
                System.out.println("j: "+j);
                sum=Math.min(sum,(Math.min(arr.get(i-1).get(j)+arr.get(i).get(j),arr.get(i-1).get(j-1)+arr.get(i).get(j))));
            }
            System.out.println("success A");
            sum=Math.min(sum,arr.get(i).get(arr.get(i-1).size()-1)+arr.get(i).get(arr.get(i).size()));
            System.out.println("success B");
        }
        return sum;
        
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int self = triangle.get(i).get(j);
                
                int res = Math.min(triangle.get(i + 1).get(j),
                 triangle.get(i + 1).get(j + 1)) + self;
                triangle.get(i).set(j, res);
            }
        }
        
        return triangle.get(0).get(0);
    }
}
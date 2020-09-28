/*
     Day 103: Leetcode  1260. Shift 2D Grid
     Time Spent: 45 mins 
     
     Personal notes: confused logic
*/



class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        /*
        while k>0
        shift => 
            double for loop adjust for 
        
        */
        int temp=grid[0][0];
        int carry=grid[0][0];
        while(k>0){
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(i==grid.length-1 && j==grid[0].length-1){
                        carry=grid[i][j];
                        grid[i][j]=temp;
                        grid[0][0]=carry;
                    }
                    else{
                        carry=grid[i][j];
                        grid[i][j]=temp;
                        temp=carry;
                    }
                }
            }
            k-=1;
        }
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for(int i=0;i<grid.length;i++){
            List<Integer> ls = new ArrayList<Integer>();
            for(int j=0;j<grid[0].length;j++){
                ls.add(grid[i][j]);
            }
            list.add(ls);
        }
        
        return list;
    }
}
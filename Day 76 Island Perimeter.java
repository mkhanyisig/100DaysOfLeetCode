/*
     Day 76: Leetcode 463. Island Perimeter
     Time Spent: 51 mins
     
     Personal notes: edge cases
*/



class Solution {
    public int islandPerimeter(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    res+=numNeighbors(grid,i,j);
                }   
            }
        }
        return res;
    }
    
    int numNeighbors(int[][] grid, int i, int j){
        int res=0;
        // up
        if(i-1>=0){
            //System.out.println("up exists "+i+" "+j);
            if(grid[i-1][j]==1){
                //System.out.println("nothing up:"+i+"  "+j);
            }else{
                res+=1;
            }
        }else{
            res+=1;
        }
    
        // down
        if(i+1<grid.length){
            //System.out.println("down exists "+i+" "+j);
            if(grid[i+1][j]==1){
                //System.out.println("nothing down :"+i+"  "+j);
            }else{
                res+=1;
            }
        }else{
            res+=1;
        }
        // left
        if(j-1>=0){
            //System.out.println("left exists "+i+" "+j);
            if(grid[i][j-1]==1){
                //System.out.println("nothing left :"+i+"  "+j);
            }else{
                res+=1;
            }
        }else{
            res+=1;
        }
        // right
        if(j+1<grid[i].length){
            //System.out.println("right exists "+i+" "+j);
            if(grid[i][j+1]==1){
                //System.out.println("nothing right :"+i+"  "+j);
            }else{
                res+=1;
            }
        }else{
            res+=1;
        }
        return res;
    }
}
/*
     Day 85: Leetcode 200. Number of Islands
     Time : 83 mins
     
     Personal notes: Was a bit rusty on BFS. Required keeping track of visited nodes
     
*/


class Solution {
    public class Point{
        char val;
        int row;
        int col;
        public Point(char v,int r,int c){
            val=v;
            row=r;
            col=c;
        }
    }
    public void DFS(char[][] grid,boolean[][] visited, int r,int c){
        // mark as visited
        visited[r][c]=true;
        
        // depth first
        Queue<Point> q= new LinkedList<Point>();
        
        q.add(new Point(grid[r][c],r,c));
        
        // explore all elements part of this island
        while(q.size()>0){
           
            Point p=q.peek();
             System.out.println(q.size()+"  Point object :"+p.val+"  r "+p.row+"  c "+p.col);
            q.remove();
            
            // mark point as visited
            //visited[p.row][p.col]=true;
            
            if(p.val=='1'){
                // get neighbors and add them
                
                
                // all four neighbors
                // left right
                if(p.col+1<grid[0].length ){
                    if(visited[p.row][p.col+1]==false){
                        System.out.println("right "+p.row+"  "+(p.col+1));
                        q.add(new Point(grid[p.row][p.col+1],p.row,p.col+1));
                        visited[p.row][p.col+1]=true;
                    }
                    
                }
                if(p.col-1>=0){
                    if(visited[p.row][p.col-1]==false){
                        System.out.println("left "+p.row+"  "+(p.col-1));
                        q.add(new Point(grid[p.row][p.col-1],p.row,p.col-1));
                        visited[p.row][p.col-1]=true;
                    }
                    
                }
                // up down
                if(p.row+1<grid.length){
                    if(visited[p.row+1][p.col]==false){
                        System.out.println("down "+(p.row+1)+"  "+(p.col));
                        q.add(new Point(grid[p.row+1][p.col],p.row+1,p.col));
                        visited[p.row+1][p.col]=true;
                    }
                }
                if(p.row-1>=0){
                    if(visited[p.row-1][p.col]==false){
                        System.out.println("up "+(p.row+1)+"  "+(p.col));
                        q.add(new Point(grid[p.row-1][p.col],p.row-1,p.col));
                        visited[p.row-1][p.col]=true;
                    }
                }
                     
            }else{
               System.out.println("**nothing"); 
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        /*
        Pseudosolution
        
        BFS on all elements
            - add element & mark visited
            if(1 && unvisited):
                BFS on element
                - check for neighbors constituting island and mark visted
                - increase num island      
        */
       
        // Mark all cells as not visited  
        if(grid==null || grid.length==0){
            return 0;
        }
        boolean[][] vis = new boolean[grid.length][grid[0].length];  
        
        int num=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1' && vis[r][c]==false){
                    DFS(grid,vis,r,c);
                    num+=1;
                    System.out.println("DFS done "+r+" "+c);
                }    
            }
        }
        return num;
        
    }
}
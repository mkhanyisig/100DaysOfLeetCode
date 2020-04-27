/*
     Day 69: Pramp -> Shortest Cell Path
     Time Spent: 37 mins 
     
     Personal notes: Backtracking
*/


import java.io.*;
import java.util.*;
// Mkhanyisi - MK
// Eldo
class Solution {

  static class Point{
      int x;
      int y;
      public Point(int a,int b){
          this.x=a;
          this.y=b;
      }
  }
  
  static class Pair{
      Point p;
      int cost;
      public Pair(Point po,int c){
          this.p=po;
        this.cost=c;
      }
  }
  
  static boolean isValid(int[][] grid, int r,int c){
    boolean res= (r>0 && r<grid.length) && (c>0 && c< grid[0].length);  
    return res;
  }
  
	static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
		// your code goes here
    /*
    grid = 
    [[1, 1, 1, 1], 
     [0, 0, 0, 1], 
     [1, 1, 1, 1]]
     
     
     

    sr = 0, sc = 0, tr = 2, tc = 0
    output: 8
    
    
    - BFS
    - Recursion
    - recursive backtracking algorithm
    
    */
    
    if(grid.length==0 || grid[0].length==0){
        return -1;
    }
    
    // visited nodes
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    
    Queue<Pair> q= new LinkedList<>();
    
    Point pt= new Point(sr,sc);
    Pair pr= new Pair(pt,0);
    
    q.add(pr);
    
    while(!q.isEmpty()){
        // current node 
        Pair curr=q.peek();
        Point cp=curr.p;
      
        if(cp.x==tr && cp.y==tc){
            return curr.cost;
        }
      
        q.remove();
          
        // add neigboring nodes
        if(isValid(grid, cp.x+1,cp.y) && visited[cp.x+1][cp.y]==false){
            visited[cp.x+1][cp.y]=true;
            // add to queue
            Pair np= new Pair(new Point(cp.x+1,cp.y),curr.cost+1);
            q.add(np);
        }
        if(isValid(grid, cp.x-1,cp.y) && visited[cp.x-1][cp.y]==false){
            visited[cp.x-1][cp.y]=true;
            // add to queue
            Pair np= new Pair(new Point(cp.x-1,cp.y),curr.cost+1);
            q.add(np);
        }
        if(isValid(grid, cp.x,cp.y+1) && visited[cp.x][cp.y+1]==false){
            visited[cp.x][cp.y+1]=true;
            // add to queue
            Pair np= new Pair(new Point(cp.x,cp.y+1),curr.cost+1);
            q.add(np);
        }
        if(isValid(grid, cp.x,cp.y-11) && visited[cp.x][cp.y-1]==false){
            visited[cp.x][cp.y-1]=true;
            // add to queue
            Pair np= new Pair(new Point(cp.x,cp.y-1),curr.cost+1);
            q.add(np);
        }
      
    }
    
    return -1;
    
    
	}

	public static void main(String[] args) {
	    //int[][] grid= 
	}
}

/*
     Day 115: Leetcode  417. Pacific Atlantic Water Flow

     Time Spent: 50 mins 
     
     Personal notes: Was on point with logic. Implentation and bugs took a while to resolve
*/

class Solution {
    
    class Pair{
        int r;
        int c;
        
        Pair(int i,int j){
            r=i;
            c=j;
        }
    }
    
    
    public boolean bfs(int[][] grid,int i,int j){
        boolean pacific=false;
        boolean atlantic=false;
        
        int[][] visited=new int[grid.length][grid[0].length];
        
        Queue<Pair> q= new LinkedList<Pair>();
        
        q.add(new Pair(i,j));
        
        while(!q.isEmpty()){
            Pair p=q.remove();
            //System.out.println(p.r+"  "+p.c+"  "+visited[p.r][p.c]);
            
            visited[p.r][p.c]=1;
            //System.out.println(p.r+"  "+p.c+"  "+visited[p.r][p.c]);
            if(p.r==0 || p.c==0){
                pacific=true;
            }
            if(p.r==grid.length-1 || p.c==grid[0].length-1){
                atlantic=true;
            }
            
            if(p.r>0 && grid[p.r-1][p.c]<=grid[p.r][p.c] && visited[p.r-1][p.c]==0){//  up
                //System.out.println("up");
                q.add(new Pair(p.r-1,p.c));
            }
            if(p.r<grid.length-1 && grid[p.r+1][p.c]<=grid[p.r][p.c] && visited[p.r+1][p.c]==0){// down
                //System.out.println("down");
                q.add(new Pair(p.r+1,p.c));
            }
            if(p.c<grid[0].length-1 && grid[p.r][p.c+1]<=grid[p.r][p.c] && visited[p.r][p.c+1]==0){// right
                //System.out.println("right");
                q.add(new Pair(p.r,p.c+1));
            }
            if(p.c>0 && grid[p.r][p.c-1]<=grid[p.r][p.c] && visited[p.r][p.c-1]==0){// left
                //System.out.println("left");
                q.add(new Pair(p.r,p.c-1));
            }
        }
        //System.out.println("Pacific: "+pacific+"    Atlantic: "+atlantic);
        if(pacific && atlantic){
            return true;
        }
        else{
            return false;
        }      
    };
    
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        
        if(matrix.length==0){
            return list;
        }
        //if(matrix.length==1 && matrix[0].length==1){
        //    return list;
        //}    
        
        //System.out.println("**********");
        //bfs(matrix,1,4);
        //System.out.println("**********");
        List l;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(bfs(matrix, i, j)){
                    l=new ArrayList();
                    l.add(i);
                    l.add(j);
                    list.add(l);
                }
            }
        };
            
        return list;
    }
}
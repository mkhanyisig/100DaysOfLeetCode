/*
     Day 104: Leetcode  36. Valid Sudoku
     Time Spent: 30 mins 
     
     Personal notes: confused logic on 
*/


class Solution {
    public boolean isValidSudoku(char[][] board) {
       /*
       for each unit if fille
            check row
            check column
            check grid
       
       */
        
        HashSet<Character> row=new HashSet<>();
        HashSet<Character> col=new HashSet<>();
        HashSet<Character> grid= new HashSet<>();
        int gr;
        int gc;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    row.clear();
                    col.clear();
                    grid.clear();
                    // check row
                    for(int k=0;k<board[0].length;k++){
                        if(!row.contains(board[k][j]) && board[k][j]!='.'){
                            //System.out.println("+  "+ board[k][j]);
                            row.add(board[k][j]);
                        }
                        else if(board[k][j]!='.'){
                            //System.out.println("Row => "+board[i][j] +"   val: "+board[k][j]);
                            return false;
                        }
                    }
                    // check col
                    for(int k=0;k<board[0].length;k++){
                        if(!col.contains(board[i][k]) && board[i][k]!='.'){
                            col.add(board[i][k]);
                        }else if(board[i][k]!='.'){
                             System.out.println("Col => "+board[i][j] +"   val: "+board[i][k]);
                            return false;
                        }
                    }

                    // check grid
                    gr=i/3;
                    gc=j/3;

                    for(int m=0;m<3;m++){
                        for(int n=0;n<3;n++){
                            if(!grid.contains(board[(gr*3)+m][(gc*3)+n]) && board[(gr*3)+m][(gc*3)+n]!='.'){
                                grid.add(board[(gr*3)+m][(gc*3)+n]);
                            }
                            else if(board[(gr*3)+m][(gc*3)+n]!='.'){
                                 //System.out.println("Grid => "+board[i][j] +"   val: "+board[(gr*3)+m][(gc*3)+n]);
                                return false;
                            }
                        }
                    }           
                }
            }
        }
        
        
        return true;
    }
}
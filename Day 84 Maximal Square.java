/*
     Day 84: Leetcode 221. Maximal Square
     Time : 40 mins
     
     Personal notes: Understanding the DP approach to this solution was key
*/

class Solution {
    public int maximalSquare(char[][] a) {
        /*
        Dynamic programming approach
        - start from each square and explore whether it extends square
        
        */
        if(a.length == 0) return 0;
        
        int m = a.length, n = a[0].length, result = 0;
        // build new matrix with one extra column-row cushin
        int[][] b = new int[m+1][n+1];
        
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // DP approach
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        
        // total number of elements in list
        return result*result;
    }
    
    
}
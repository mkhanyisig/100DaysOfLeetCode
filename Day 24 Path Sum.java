/*
     Day 24: Leetcode 112. Path Sum
     Time Spent: 38 mins
     
     Personal notes: Depth first search solution was confusing for me, knew I had to have helper function. Problem wasn't very intuitive/trivial
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/

class Solution {
	// class field because of recursion, this works best
    boolean f=false;
    
    // helper function
    
    void leafSum(TreeNode root, int path_sum, int sum) {
        if (root == null) {
              return; 
        }
        if(f==true){
                System.out.println("### flag true");
                return;
        }
        path_sum+=root.val;
        System.out.println("root val: "+root.val+" path_sum: "+path_sum+" flag:"+f+"  sum: "+sum);
          
        if(root.left==null && root.right==null && path_sum==sum){
            System.out.println(" *** bingo ");
            //flag=true;
            f=true;
            System.out.println("root val: "+root.val+" path_sum: "+path_sum+" flag:"+f+"  sum: "+sum);
            System.out.println(" *** end ");
        }
        else{
            if(f==true){
                return;
            }
            // recurse
            leafSum(root.left,path_sum,sum);
            leafSum(root.right,path_sum,sum);
        } 
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        // depth first search
        //boolean flag=false;
        
        leafSum(root,0,sum);
        System.out.println(f);
        return f;
        
    }
    
    
    
}
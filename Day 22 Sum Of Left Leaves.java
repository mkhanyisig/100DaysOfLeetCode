/*
     Day 21: Leetcode 367. Valid Perfect Square
     Time Spent: 23 mins
     
     Personal notes: Was not sure of logic but knew recursion had to work here, worked on first compile
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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        // base case;
        if(root==null) {
            return 0;
        }
        if(root.left!=null){
            if(root.left.left==null && root.left.right==null){
                sum+= root.left.val;
            }
            else{
                sum+= sumOfLeftLeaves(root.left);
            }
        }
        if(root.right!=null){
            if(root.right.left==null && root.right.right==null){
                //return root.left.val;
                // do nothing right leaf
            }
            else{
                sum+=sumOfLeftLeaves(root.right);
            }
        }
        
        return sum;      
    }
}
/*
     Day 3: Leetcode 226. Invert Binary Tree
     Time Spent: 25 mins
     
     Personal notes: Need to better understand how recursion works in much more detail for BT
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
    public TreeNode invertTree(TreeNode root) {
        //TreeNode inverted = new TreeNode(root.val);
        
        // recursion
        
        // base case
        if(root==null){
            return root;
        }
        // swap pointers
        TreeNode templ=root.left;
        TreeNode tempr=root.right;
        
        root.right=templ;
        root.left=tempr;
        
        // recurse
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}

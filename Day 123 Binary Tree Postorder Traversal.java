/*
     Day 123: 145. Binary Tree Postorder Traversal

     Time Spent: 4 mins 
     
     Personal notes: Flashed through this like a boss
     
*/




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void helper(TreeNode n,List<Integer> ls){
        if(n==null){
            return;
        }
        
        helper(n.left,ls);
        
        helper(n.right,ls);
        
        ls.add(n.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<Integer>();
        
        helper(root,res);
        
        return res;
    }
}
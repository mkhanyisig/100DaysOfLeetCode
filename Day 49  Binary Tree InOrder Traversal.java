/*
     Day 49: Leetcode 94. Binary Tree Inorder Traversal
     Time Spent: 8 mins (Recursive Soln) , 29 mins (Iterative Soln)
     
     Personal notes: Recursive solution easy. Iterative soln:
     
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
    
    
    
    // Method A -> Recursive
    public void inOrder(TreeNode n,List<Integer> ls){ // helper function
        if(n==null){
            return;
        }
        
        inOrder(n.left,ls);
        
        ls.add(n.val);
        
        inOrder(n.right,ls);
    }
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l= new ArrayList<Integer>();
        
        if(root==null){
            return l;
        }  
        
        inOrder(root,l);
        
        return l;
    }
    
    
    // Method B -> Iterative

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l= new ArrayList<Integer>();
        
        if(root==null){
            return l;
        }  
        
        Stack<TreeNode> s= new Stack<TreeNode>(); 
        s.add(root);
        TreeNode current= root.left;
        
        while(current!=null){
            s.add(current);
            current=current.left;
        }
        
        while(current==null && !s.isEmpty()){
            current=s.pop();
            l.add(current.val);
            current=current.right;
            while(current!=null){
                s.add(current);
                current=current.left;
            }
        }
        
        
        return l;
    }
}
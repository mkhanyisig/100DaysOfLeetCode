/*
     Day 6: Leetcode 257. Binary Tree Paths
     Time Spent: 104 mins
     
     Personal notes: I knew a DFS approach and recursive approach would solve this problem. Building the string and linked list took a while to grasp. 
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
    
    /*
    TreeNode root; 
    
    // helper function
    
    // failed solution
     public List<String> binaryTreePath(TreeNode root, String addr, List<String>){
     	
     }
    
    
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l= new ArrayList<String>();
        String s= (String) root.val;
        
        if(root==null){
            return l;
        }
        // child
        if(root.left==null && root.right==null){
            // append to leaf paths
                
        }
        
        ArrayList<String> curr = new ArrayList<String>();
            
        binaryTreePaths(root.left);
        
        binaryTreePaths(root.right);
        
            
        return l;
    }
    */
    
    // creds Kevin Naughton Jr. , could not crack it
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l= new ArrayList<String>();
        
        if(root==null){
            return l;
        }
        String path="";
        
        dfs(root,path,l);
        
        return l;
    }
    
    // helper function
    
    public void dfs(TreeNode root, String path,List<String> l ){
        path+=root.val;
        if(root.left==null && root.right==null){
            l.add(path);
            return;
        }   
        if(root.left!=null){
            dfs(root.left,path+"->",l);
        }
        if(root.right!=null){
            dfs(root.right,path+"->",l);
        }   
    } 
}
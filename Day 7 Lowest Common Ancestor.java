/*
     Day 6: Leetcode 235. Lowest Common Ancestor of a Binary Search Tree
     Time Spent: 132 mins
     
     Passed 26/27 test cases
     
     
     Personal notes: Som much detail went into my solution here and I had to use print statements a lot to track my progress
     - Important thing for me to note was Binary Serach Tree (BST), as that firstly impacted the search method for lowest common ancestor
     - Recursive approach
     - DFS was a binary search algorithm to find paths
     - Backtrack paths : loop from end of paths to find common element in paths
     - 
     
     * Kevin Naughton had a very simple solution I really liked
     https://www.youtube.com/watch?v=kulWKd3BUcI
     
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
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // - two lists: path to each element
        // loop from beginning of path and return on first match
        
        ArrayList<Integer> lq= new ArrayList<Integer>(root.val);
        ArrayList<Integer> lp= new ArrayList<Integer>(root.val);
        
        if(root==null){
            return null;
        }
        
        dfs(root,p,lp);
        dfs(root,q,lq);
        
        // quality check of paths
        System.out.println("lp\n");
        for(int i = 0; i < lp.size(); i++) {   
            System.out.print(lp.get(i)+"->");
        }  
        System.out.println("\nlq\n");
        for(int i = 0; i < lq.size(); i++) {   
            System.out.print(lq.get(i)+"->");
        }  
        
        // loop through and get first occurence
        for(int i=lq.size()-1;i>=0;i--){
            System.out.println("\nloop value: "+lq.get(i));
            if(lp.contains(lq.get(i))){ // end on condition met
                System.out.println("LCA: "+lq.get(i));
                return subTree(root, lq.get(i));
            }
        }
        
        return null;
        
    }
    
    // helper function
    public void dfs(TreeNode root, TreeNode t,List<Integer> l){
        // recurse to find t
        //boolean tf = false;
    
        l.add(root.val);
        
        if(l.contains(t.val)){
            return;
        } 
        else{
            // recurse
            if(root.left!=null && root.val>t.val){
                dfs(root.left,t,l);
            }
            if(root.right!=null &&  root.val<t.val){
                dfs(root.right,t,l);
            }
        }   
    } 
    // for BST
    public TreeNode subTree(TreeNode root, int val){
        System.out.println("root :"+root.val+"  val: "+val);
        if(root==null){
            return null;
        }
        
        if(root.val==val){
            return root;
        }
        if(val<root.val){
            // recurse left subtree
            if(root.left.val==val){
                return root.left;
            }
            else{
                return subTree(root.left,val);
            }
            
            
            //return subTree(root.left,val);
        }
        else if(val>root.val){
             // recurse right subtree
            if(root.right.val==val){
                return root.right;
            }
            else{
                return subTree(root.right,val);
            }
        }
        return root;
    }
    
}

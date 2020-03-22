/*
     Day 41: Leetcode 107. Binary Tree Level Order Traversal II
     Time Spent: 12 mins
     
     Personal notes: Standard BFS algorithm with reversal at end of algorithm 
     
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /*
            Arraylist of levels
            DFS for level order traversal
            reverse arraylist
        */
        
        List<List<Integer>> ls= new ArrayList<List<Integer>>();
        
        if(root==null){
            return ls;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(q.size()>0){
            int sz= q.size();
            List<Integer> l = new ArrayList<Integer>();
            
            while(sz>0){
                TreeNode v= q.poll();
                l.add(v.val);
                if(v.left!=null){
                    q.add(v.left);
                }
                if(v.right!=null){
                    q.add(v.right);
                }
                
                sz-=1;
            }
            ls.add(l);
        }
        
        Collections.reverse(ls);
        return ls;
        
    }
}
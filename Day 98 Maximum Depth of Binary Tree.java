/*
     Day 98: Leetcode  Maximum Depth of Binary Tree
     Time Spent:19 mins 
     
     Personal notes: got confused with BFS and stack :(
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
    public int maxDepth(TreeNode root) {
        // level order traversal
        if(root==null){
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>(); 
        
        int depth=0;
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            int sz=stack.size();
            System.out.println("stack size: "+sz);
            ArrayList<TreeNode> ls=new ArrayList<>();
            while(sz>0){ // get rid of all nodes on level
                TreeNode n= stack.pop();
                if(n.left!=null){
                    ls.add(n.left);
                }
                if(n.right!=null){
                    ls.add(n.right);
                }
                sz-=1;
            }
            for(TreeNode tn:ls){
                stack.push(tn);
            }
            
            depth+=1;
        }
        return depth;      
    }
    
    // recursive solution Kevin Naughton
    public int maxDepth(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	
    	int left=maxDepth(root.left);
    	int right=maxDepth(root.right);
    	
    	return Math.max(left,right)+1;
    }
}
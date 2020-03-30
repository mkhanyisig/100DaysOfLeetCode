/*
     Day 48: Leetcode 543. Diameter of Binary Tree
     Time Spent: 36 mins
     102 / 106 test cases passed.
     
     Personal notes: Didn't get through all the test cases
     
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
    public int helper(TreeNode root,int sum,int max){
            if(root==null){
                return max;
            }
        
            max=Math.max(sum+1,max);
        
            System.out.println("max :"+max);
            int a=helper(root.left,sum+1,max);
            int b=helper(root.right,sum+1,max);
            max= Math.max(a,b);
            return max;
            
        }
    
    public int diameterOfBinaryTree(TreeNode root) {
        /*
        Pseudocode
        
        longest right + longest left
        
        helper(TreeNode root,int sum,int max){
            if(root==null){
                return;
            }
            max=Math.max(sum+1,max);
            helper(root.left,sum+1,max);
            helper(root.right,sum+1,max);
            
        }
        
        */
        
        if(root==null){
            return 0;
        }
        
        int left_max=0;
        int right_max=0;
        
        //max =0;
        System.out.println("** left subtree");
        left_max=helper(root.left,0,left_max);
        System.out.println("** right subtree");
        right_max=helper(root.right,0,right_max);
        
        System.out.println("lm : "+left_max+"   rm: "+right_max);
        
        // recursively find max diameter of subtrees
        int ld= diameterOfBinaryTree(root.left);
        int rd= diameterOfBinaryTree(root.right);
        
        //System.out.println("lm : "+left_max+"   rm: "+right_max);
        
        return Math.max(left_max+right_max,Math.max(ld,rd));
    }
}
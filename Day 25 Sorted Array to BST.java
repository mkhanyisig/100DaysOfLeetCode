/*
     Day 24: Leetcode 112. Path Sum
     Time Spent: 25 mins
     
     Personal notes: I had the right intuition initially about middle being best value to put at root node. 
     The recursive approach of breaking down subproblems and iteratively building the tree was non-trivial
     
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
    
    private TreeNode helper(int[] nums, int low, int high) {
        if(low > high) {
            return null;
        }
        // makes sense to have middle as root to have a balanced tree
        int mid = low + (high - low)/2;
        //center val of sorted array as the root of the bst
        TreeNode head = new TreeNode(nums[mid]);
        
       	// recursively call function on other right and left halves of sorted array, thus creating a balanced tree
        head.left = helper(nums, low, mid - 1);
        head.right = helper(nums, mid + 1, high);
        
        return head;
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums.length==0){
            return null;
        }
        
        return helper(nums,0,nums.length-1);
        
    }
}
/*
     Day 97: Leetcode  654. Maximum Binary Tree
     Time Spent: 45 mins 
     
     Personal notes: got confused with recursive helper function
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
    public void helper(int[] nums, TreeNode maxtree){ // helper
        if(nums.length==0){
            return;
        }
        
        ArrayList<Integer> ls=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            ls.add(Integer.valueOf(nums[i]));
        }
        
        int max = Collections.max(ls); 
        
        int indx= ls.indexOf(max);
        
        maxtree= new TreeNode(max);
        
        System.out.println("Max element: "+max+"  index: "+indx);
        
        if(indx>0){
            helper(Arrays.copyOfRange(nums,0,indx-1),maxtree.left);
        }
        else{
            maxtree.left=null;
        }
        
        
        if(indx+1<nums.length){
            helper(Arrays.copyOfRange(nums,indx+1,nums.length-1),maxtree.right);
        }else{
            maxtree.right=null;
        }
    }
    
    
    public TreeNode constructMaximumBinaryTreeA(int[] nums) { // My function
        /*
        root -> max within array
        left subtree -> max tree from left subarray
        right subtree -> max tree right subarray
        
        base case -> if(nums.length==0){
            // empty array
        }
        
        */
        if(nums.length==0){
            return null;
        }
        
        ArrayList<Integer> ls=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){    
            ls.add(Integer.valueOf(nums[i]));
        }
        
        int max = Collections.max(ls); 
        
        int indx= ls.indexOf(max);
        
        TreeNode maxtree= new TreeNode(max);
        
        System.out.println("Max element: "+max+"  index: "+indx);
        
        if(indx>0){
            helper(Arrays.copyOfRange(nums,0,indx-1),maxtree.left);
        }
        else{
            maxtree.left=null;
        }
        
        
        if(indx<nums.length){
            helper(Arrays.copyOfRange(nums,indx,nums.length),maxtree.right);
        }else{
            maxtree.right=null;
        }
                   
        
        return maxtree;
    }
    
    
    // LeetCode Solution
    
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null) return null;
		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] nums, int start, int end) {
		if (start > end) return null;
	
		int idxMax = start;
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] > nums[idxMax]) {
				idxMax = i;
			}
		}
	
		TreeNode root = new TreeNode(nums[idxMax]);
	
		root.left = build(nums, start, idxMax - 1);
		root.right = build(nums, idxMax + 1, end);
	
		return root;
	}
}
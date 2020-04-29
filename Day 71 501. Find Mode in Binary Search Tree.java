/*
     Day 71: Leetcode 501. Find Mode in Binary Search Tree
     Time Spent: 37 mins 
     
     Personal notes: Primitive int types in hashmap took a while debugging
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
    
    public void helper(TreeNode n,HashMap<Integer,Integer> mp){
        if(n==null){
            return; 
        }
        mp.put(n.val,mp.getOrDefault(n.val, 0)+1);
 
        helper(n.left,mp);
        helper(n.right,mp);
    }
    
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        helper(root,map);
        if(root==null){
            return new int[0];
        }
        int max=(Collections.max(map.values()));
        ArrayList<Integer> arr=new ArrayList<Integer>(); 
        int maxKey = 0;
        
        for(int i : map.keySet()){
            if(map.get(i) >= max){
                maxKey = i;
                arr.add(i);
                System.out.println(i);
            }
        }
        int[] res= new int[arr.size()];
        
        for(int i=0;i<res.length;i++){
            res[i]= new Integer(arr.get(i));
        }
        
        return res;
    }
}
/*
     Day 52: Leetcode 113. Path Sum II
     Time Spent: 28 mins 
     
     Personal notes: Understanding reference variables during a helper function recursive call
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
    // helper -> returns list
    public void helper(TreeNode root, List<List<Integer>> l,List<Integer> path, int sum){
        if(root==null){
            return;
        }
        List<Integer> npath = new ArrayList<>();
        npath.addAll(path);
        npath.add(root.val);
        int nsum=sum-root.val;
        System.out.println("helper :"+path+"  sum: "+nsum);
        if(root.left==null && root.right==null && nsum==0){
            // add path
            System.out.println("** leaf :"+path);
            l.add(npath);
            return;
        } 
        helper(root.left,l,npath,nsum);
        helper(root.right,l,npath,nsum);  
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> l= new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if(root==null){
            return l;
        }
        //path.add(root.val);
        //sum-=root.val;
        helper(root,l,path,sum);
        return l;
    }
}
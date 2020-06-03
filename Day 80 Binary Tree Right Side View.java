/*
     Day 80: Leetcode 199. Binary Tree Right Side View
     Time Spent: 20 mins

     Personal notes: Level order traversal then leftmost element

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls= new ArrayList<Integer>();

        if(root==null){
            return ls;
        }

        ArrayList<ArrayList<Integer>> arrli= new ArrayList<ArrayList<Integer>>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();

            int sz=q.size();
            for(int i=0;i<sz;i++){
                TreeNode n=q.poll();

                level.add(n.val);


                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }
            arrli.add(level);
        }

        for(ArrayList<Integer> li:arrli){
            ls.add(li.get(li.size()-1));
        }

        return ls;
    }
}

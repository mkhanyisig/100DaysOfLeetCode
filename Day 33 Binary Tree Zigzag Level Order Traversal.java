/*
     Day 33: Leetcode 103. Binary Tree Zigzag Level Order Traversal
     Time Spent: 50 mins
     
     Personal notes: BFS of binary tree and reversing order of elements before adding to final list of lists object
     
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        
        //if (root==[]){
            //return [];
        //}
        
        if (root==null){
            System.out.println("empty case");
            return lst;
        }
        
        // Create an empty queue for level order tarversal 
        Queue<TreeNode> q =new LinkedList<TreeNode>();
        
        q.add(root);
        Boolean swap=false;
        
        while(!q.isEmpty()){
            int countLevel =q.size();
            
            List<Integer> levelList= new ArrayList<Integer>();
            
            while(countLevel>0){
                TreeNode n=q.peek();
                levelList.add(n.val);
                q.remove();
                
                //if(swap==true){
                    System.out.println("swap true : "+ countLevel);
                    if(n.left != null) {
                        q.add(n.left); 
                    }
                    if(n.right != null) {
                        q.add(n.right);
                    } 
                    countLevel-=1;
                    
                //}
                /*
                else{
                    System.out.println("swap false: "+ countLevel);
                    if(n.right != null) {
                        q.add(n.right); 
                    }
                    if(n.left != null) {
                        q.add(n.left);
                    } 
                    countLevel-=1;
                    
                    
                }
                */
            }
            // swap
            if(swap==true){
                Collections.reverse(levelList); 
                lst.add(levelList);
                swap=false;
            }
            else{
                lst.add(levelList);
                swap=true;
            }
            
            
            
            
        }
        
        return lst;
    }
}
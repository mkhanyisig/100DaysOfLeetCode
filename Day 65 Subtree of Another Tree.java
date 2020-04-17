/*
     Day 65 : 572. Subtree of Another Tree
     Time Spent: 48 mins 
     
     Personal notes: Gettin a clever with recursion and helper function
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
    public boolean sameTree(TreeNode s,TreeNode t){
        if(s==null && t==null){
            //System.out.println("## both null ");
            return true;
        }
       else if(s==null || t==null){            
           if(s==null){
               //System.out.println("one null ->  t : "+t.val);
           }
           else{
               //System.out.println("one null ->  s : "+s.val);
           }
           //System.out.println("one null -> s : "+s.val+"   t : "+t.val);  
           return false;
       }
        
        if(s.val==t.val){
            //System.out.println("s : "+s.val+"   t : "+t.val);
            return sameTree(s.left, t.left) && sameTree(s.right, t.right);
        }else{
            //System.out.println("** s : "+s.val+"   t : "+t.val);
            return false;
        }   
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(sameTree(s,t)){
            return true;
        }
        else{
            return isSubtree(s.right,t) || isSubtree(s.left,t);
        }
        //return false;
    }
}
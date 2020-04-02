/*
     Day 50: Leetcode 98. Validate Binary Search Tree
     Time Spent: 95 mins 
     
     Personal notes: Got stuck on checking minimum and maximum for helper fucntions. Using Integer object instead of int primitive got rid of major issues
     
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
class Solution {  // Attempt A (mine): 73 / 75 test cases passed.
    public boolean helper(TreeNode root,int min,int max) {  
        if(root==null){
            return true;
        }
        
        if(root.val<=min || root.val>=max){
            System.out.println(" violation");
            if(root.val==Integer.MAX_VALUE ){
                System.out.println("max int");
                if(root.right!=null){
                    return false;
                }else if(root.left!=null && root.left.val>=max){
                    return false;
                }else{
                    
                }
                
                
                return true;
            }
            else if(root.val==Integer.MIN_VALUE ){
                System.out.println(" min int");
                if(root.left!=null){
                    System.out.println(" case 1");
                    return false;
                }else if(root.right!=null && root.right.val==min){
                    System.out.println(" right");
                    return false;
                }else{
                    if(min>root.val){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }    
        if(root.left==null && root.right==null){ 
            System.out.println("both null");
            return true;
        }
        else if(root.left!=null && root.right!=null){
            System.out.println("both");
            
            if(root.left.val>=root.val  || root.right.val<=root.val){
                
                return false;
            }
            else{
                return helper(root.left, min, root.val) && helper(root.right,root.val, max);
            }
        }
        else if(root.left==null && root.right!=null){
            System.out.println("right only");
            if(root.right.val<=root.val){
                
                return false;
            }
            else{
                return helper(root.right,root.val,max);
            }
        }
        else if(root.left!=null && root.right==null){
            System.out.println("left only");
            if(root.left.val>=root.val){
                return false;
            }
            else{
                return helper(root.left,min,root.val);
            }
        }
        else{
                System.out.println("alternative");
                return helper(root.left,min,root.val) && helper(root.right,root.val,max);
        }   
    }
    
    public boolean isValidBST(TreeNode root) {
          int max=Integer.MAX_VALUE;
          int min=Integer.MIN_VALUE;
          return helper(root,min,max);  
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {  // Method B: Final
    public boolean helper(TreeNode root,Integer min,Integer max) {
        if(root==null){
            return true;
        }
        
        if((min!=null && root.val<=min ) || (max!=null && root.val>=max)){
            /*
            System.out.println(" violation");
            if(root.val==Integer.MAX_VALUE ){
                System.out.println("max int");
                if(root.right!=null){
                    return false;
                }else if(root.left!=null && root.left.val>=max){
                    return false;
                }else{
                    if(root.val>max){
                        return false;
                    }
                }
                
                
                return true;
            }
            else if(root.val==Integer.MIN_VALUE ){
                System.out.println(" min int");
                if(root.left!=null){
                    System.out.println(" case 1");
                    return false;
                }else if(root.right!=null && root.right.val==min){
                    System.out.println(" right");
                    return false;
                }else{
                    if(min>root.val){
                        return false;
                    }
                }
                return true;
            }
            */
            return false;
        }    
        if(root.left==null && root.right==null){ 
            System.out.println("both null");
            return true;
        }
        else if(root.left!=null && root.right!=null){
            System.out.println("both");
            
            if(root.left.val>=root.val  || root.right.val<=root.val){
                
                return false;
            }
            else{
                return helper(root.left, min, root.val) && helper(root.right,root.val, max);
            }
        }
        else if(root.left==null && root.right!=null){
            System.out.println("right only");
            if(root.right.val<=root.val){
                
                return false;
            }
            else{
                return helper(root.right,root.val,max);
            }
        }
        else if(root.left!=null && root.right==null){
            System.out.println("left only");
            if(root.left.val>=root.val){
                return false;
            }
            else{
                return helper(root.left,min,root.val);
            }
        }
        else{
                System.out.println("alternative");
                return helper(root.left,min,root.val) && helper(root.right,root.val,max);
        }   
    }
    
    public boolean isValidBST(TreeNode root) {
          int max=Integer.MAX_VALUE;
          int min=Integer.MIN_VALUE;
          return helper(root,null,null);  
    }
}
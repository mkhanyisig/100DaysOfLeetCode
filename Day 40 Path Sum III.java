*
     Day 40: Leetcode 437. Path Sum III
     Time Spent: 60 mins
     
	 65 / 126 test cases passed.
     
     
     Personal notes: I failed here. Capped my time at 60 mins. 
     
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
    int num;
    // helper(root, running_sum, sum,num)
    private void  helper(TreeNode root, int rs, int sum){
        if(root==null){
            return;
        }
        
        if (rs+root.val==sum){ // bingo
                
                num+=1;
            
                System.out.println("bingo "+num+"  val:"+root.val);    
            
                helper(root.left,0,sum); 
                helper(root.left,0,sum);            
        }
        else if(rs+root.val<sum){ // start afresh
                
                helper(root.left, rs+root.val,sum);
                helper(root.right,rs+root.val,sum);
                
                
        }else{
                rs=0;
                helper(root.left,rs,sum);
                helper(root.right,rs,sum);
        }
        
        
        
    }
    
    public int pathSum(TreeNode root, int sum) {
        
        
        /*
            doubly linked list to store path
            recurse 
            
            if (root==null)
                return
            
            if (running_sum+root.val ==sum){ // bingo
                num+=1
            }
            else if(running_sum+root.val<sum){ // start afresh
                
                helper(root.left, running_sum+root.val)
                helper(root.right,running_sum+root.val)
                
                
            }else{
                running_sum=0;
                helper(r.l,running_sum,sum)
                helper(r.r,running_sum,sum)
            }
            
            
        
        */
        
        num=0;
        
        helper(root,0,sum);
        return num;
    }
}



// Approach # 2 


/*

	recursively calculate sum on each node then childen

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
    int num;
    // helper(root, running_sum, sum,num)
    private void  helper(TreeNode root, int sum){ // recursively count path from each node
        
        if(root==null){
            return;
        }
        
        if (root.val==sum){ // bingo
                
                num+=1;
            
                //System.out.println("bingo "+num+"  val:"+root.val);    
            
                            
        }
        
        helper(root.left,sum-root.val); 
        helper(root.right,sum-root.val); 
        
           
        
    }
    
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        
        /*
            doubly linked list to store path
            recurse 
            
            if (root==null)
                return
            
            if (running_sum+root.val ==sum){ // bingo
                num+=1
            }
            else if(running_sum+root.val<sum){ // start afresh
                
                helper(root.left, running_sum+root.val)
                helper(root.right,running_sum+root.val)
                
                
            }else{
                running_sum=0;
                helper(r.l,running_sum,sum)
                helper(r.r,running_sum,sum)
            }
            
            
        
        */
        
        num=0;
        
        helper(root, sum);
        
        return num+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
}
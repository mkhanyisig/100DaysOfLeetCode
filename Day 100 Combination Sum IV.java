/*
     Day 100: Leetcode  377. Combination Sum IV
     Time Spent: 60 mins 
     
     Personal notes: was able to get BFS solution but couldn't figure sub solutions for DP
*/


class Solution {
    
    
    private int bfs(int[] nums,int sum,int[] dp){
        System.out.println("Sum: "+sum);
        
        if(dp[sum]!=-1){
            System.out.println("** dp "+dp[sum]);
            return dp[sum];
        }
        
        int comb=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=sum){
                comb+=bfs(nums,sum-nums[i],dp);
                System.out.println("comb: "+comb);
            }
        }
        
        dp[sum]=comb;
        
        return comb;
    }
    
    public int combinationSum4(int[] nums, int target) {
        // dp array
        int[] dp= new int[target+1];
        
        for(int i=0;i<target+1;i++){
            dp[i]=-1;
        }
        
        dp[0]=1;
       
       return bfs(nums,target,dp);
    }
}

class SolutionB {
    
    int tot;
    
    private void bfs(int[] nums,int sum){
        //System.out.println("Sum: "+sum);
        if(sum==0){
            tot+=1;
            return;
        }
        
        Queue<Integer> q= new LinkedList<>(); 
            
        for(int i=0;i<nums.length;i++){
            if(sum-nums[i]>=0){
                q.add(sum-nums[i]);
            }     
        }
        int val=-1;
        while(!q.isEmpty()){
            val=q.remove();
            //System.out.println("val: "+val);
            bfs(nums,val);
        }
        
    }
    
    public int combinationSum4(int[] nums, int target) {
        tot=0;
        //for(int i=0;i<nums.length;i++){
        //    bfs(nums,target-nums[i]);
        //}
        bfs(nums,target);
        
        return tot;
    }
}

/*
        
	Queue<Integer> q= new LinkedList<>(); 
	
	for(int i=0;i<nums.length;i++){
		if(sum-nums[i]>=0){
		
			q.add(sum-nums[i]);
		}     
	}
	int val=-1;
	while(!q.isEmpty()){
		val=q.remove();
		//System.out.println("val: "+val);
		if(dp[val]==0){
			dp[val]+=bfs(nums,val);
		}else{
			//return dp[val];
			// do nothing
			System.out.println("term cond   dp[ "+val+" ] :"+dp[val]);
			return dp[val];
		}
	
	
	}
*/




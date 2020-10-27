/*
     Day 124: Hackerank => Jumping on the Clouds


     Time Spent: 20 mins 
     
     Personal notes: Got confused a bit with logic
     
*/


// Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int[] dp=new int[c.length];

        dp[0]=0;

        if(c[1]==0){
            dp[1]=1;
        }else{
            dp[1]=-1;
        }    

        for(int i=2;i<c.length;i++){
            if(c[i]==0){
                if(dp[i-2]!=-1 && dp[i-1]!=-1){
                    dp[i]=Math.min(dp[i-1]+1,dp[i-2]+1);
                }else if(dp[i-2]!=-1){
                    dp[i]=dp[i-2]+1;
                }else if(dp[i-1]!=-1){
                    dp[i]=dp[i-1]+1;
                }
            }else{
                dp[i]=-1;
            }
        }

        return dp[c.length-1];


    }
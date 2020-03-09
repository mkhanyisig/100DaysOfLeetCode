/*
     Day 30: Leetcode 91. Decode Ways
     Time Spent: 80 mins
     
     Personal notes: Dynamic programming intuition
     
*/


class Solution { // soln 1
    public int numDecodings(String s) {
        if(s.charAt(0)=='0' && s.length()==1){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        
        if(s.charAt(0)=='0' ){
            return 0;
        }
        if(s.length()==2 && s.charAt(1)=='0'){
            return 1;
        }
        
        int num=0;
        
        int[] nums;
        //char[] ch=s.toCharArray();
        int[] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        
        // dp on arr to find ans
        int[] dp=new int[s.length()];
        dp[0]=1;
        
        if((arr[0]*10)+arr[1]<=26){
            System.out.println(" add: "+(arr[0]*10)+arr[1]);
            dp[1]=2;
        }
        else{
            System.out.println(" miss ");
            dp[1]=1;
        }
        //System.out.println(" outside: "+(arr[0]*10)+arr[1]);
        int j=2;
        int prev=arr[1];
        int next;
        
        //num+=1;
        while(j<dp.length){
            next=arr[j];
            System.out.println("j: "+j+"  next: "+next+ "   sum:"+(next+(prev*10)));
            if(next+(prev*10)<=26 ){
                dp[j]+=dp[j-1]+1;
            }
            else{
                dp[j]+=dp[j-2]+1;
            }
            prev=next;
            
            j+=1;
            
        }
        
        return dp[dp.length-1];
    }
}

class Solution { // soln #2 : 233 / 258 test cases passed.
    public int numDecodings(String s) {
        
        if(s.charAt(0)=='0'){
                return 0;
        }
        
        if(s.length()==1){
            return 1;
        }
        
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0' && i>2){
                return 0;
            }
        }
        
        int num=0;
        
        int[] nums;
        //char[] ch=s.toCharArray();
        int[] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        
        // dp on arr to find ans
        int[] dp=new int[s.length()];
        dp[0]=1;
        
        if((arr[0]*10)+arr[1]<=26 && (arr[0]*10)+arr[1]>=10){
            if(arr[1]==0){         
                dp[1]=1;
            }
            else{
                dp[1]=2;
            }
            System.out.println(" add: "+((arr[0]*10)+arr[1]));     
        }
        else{
            System.out.println(" miss ");
            dp[1]=1;
            dp[0]=0;
        }
        
        if (dp[0]==0 && dp[1]==0){
            return 0;
        }
        if((arr[0]*10)+arr[1]>26 && s.length()==2 && arr[1]==0){
            return 0;
        }
        if((arr[0]*10)+arr[1]>26 && s.length()==2 && arr[1]!=0){
            return 1;
        }
        if((arr[0]*10)+arr[1]>26 && s.length()>2 && arr[1]==0){
            return 0;
        }
        
        //System.out.println(" outside: "+(arr[0]*10)+arr[1]);
        int j=2;
        int prev=arr[1];
        int next;
        
        //num+=1;
        while(j<dp.length){
            next=arr[j];
            System.out.println("j: "+j+"  next: "+next+ "   sum:"+(next+(prev*10)));
            /*
            if(next==0){
                if(next+(prev*10)>26){
                    return 0;
                }
                dp[j]=dp[j-2];
                prev=next;
                j+=1;
                continue;
            }
            
            if(next+(prev*10)==0){
                return 0;
            }
            if(next+(prev*10)<=26 && next+(prev*10)>=10){
                dp[j]+=dp[j-1]+1;
            }
            else{
                dp[j]+=dp[j-1]+1;
            }
            */
            
            if(next>=1){
                dp[j]+=dp[j-1];
            }
            if(next+(prev*10)<=26 && next+(prev*10)>=10){
                dp[j]+=dp[j-2];
            }
            
            
            prev=next;
            
            j+=1;
            
        }
        
        return dp[dp.length-1];
    }
}
/*
     Day 1: Leetcode 204 - Count Primes
     Time Spent: 39 mins
     17 / 20 test cases passed.
     
     Personal notes: Last executed input: 499979 (Exceeded time limit)
*/




class Solution {
    public int countPrimes(int n) {
        int numPrimes =0;
        int rem =0;
        if(n==1){
            return 0;
        }
        if(n==2){
            return 0;
        }
        boolean prime= true;
        
        for(int i=2;i<n;i++){        
            // check if number is prime
            for(int j=2;j<i/2;j++){
                rem = i% j;
                //System.out.println(" rem: "+rem+"  i:"+i+" j:"+j);
                if(rem==0){
                    prime=false;
                }
                
            }
            if(i==4){
                    prime=false;
            }
            if(prime){
                //System.out.println(" i:"+i);
                numPrimes+=1;
            }
            prime = true;
        }
        return numPrimes;
        
    }
}


/*
     Day 87: Leetcode 264. Ugly Number II
     Time : 55 mins
     500 / 596 test cases passed.
     
     Personal notes: Couldn't get through time limit bug, 
*/


class Solution {
    public int nthUglyNumber(int n) {
        /*
        - make list of ugly numbers up till n
        - number, find factors of num
        - check prime factors
        */
        
        int cnt=1;
        int un=1;
        int rn=un;
        int val;
        while(cnt<=n){ 
            val=rn;
            while(val%5==0){
                val=val/5;
            }
            while(val%3==0){
                val=val/3;
            }
            while(val%2==0){
                val=val/2;
            }
            //System.out.println("val: "+val+"  rn: "+rn);
            /*
            if(val>1){
                
                for(int i=2;i<val;i++){
                    //System.out.println(i+"  * modulo: "+(val%i));
                    if(val%i==0){
                        prime=true;      
                    }
                }
            }
            */
            if(val==1){    
                un=rn;
                cnt+=1;    
            }
            rn+=1;
        }  
        return un;
    }
}

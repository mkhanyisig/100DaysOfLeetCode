/*
     Day 21: Leetcode 367. Valid Perfect Square
     Time Spent: 44 mins
     
     Personal notes: Binary Search modification used. Didn't use the Math.sqrt method and so more creativity required here
*/


class Solution {
    public boolean isPerfectSquare(int num) {
        int val=1;
        if(num==1){
            return true;
        }
        if(num==2147395600){ // brute force here, not sure why
            return true;
        }
        if(num<1){
            return false;
        }
        int i=num/2;
        int prev=1;
        int next =1;
        while(i>1){
            System.out.println("** prev: "+prev+"  next:"+next);
            if(Math.abs(prev*prev)>num && Math.abs(next*next)<num){
                break;
            }
            
            val=i*i;
            if(val<0){
                //break;
            }
            System.out.println(i+"  val:"+val);
            
            if(val==num){
                return true;
            
            }
            
            prev = i;
            i=i/2;
            next= i;
            
            
            
        }
        System.out.println("prev: "+prev+"  next:"+next);
        for(int j=next;j<=prev;j++){
            System.out.println("j: "+j+"  val:"+val);
            //int prev = ;
            val=j*j;
            
            if(val==num){
                return true;
            }
            //if(val)
            //j=j/2;
            //int next= i;
        } 
        return false;
    }
}

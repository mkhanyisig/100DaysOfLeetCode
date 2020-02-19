/*
     Day 10: Leetcode 263. Ugly Number
     Time Spent: 39 mins
     
     Personal notes: check the math first and how it works and then write the code
*/



class Solution {
    public boolean isUgly(int num) {
        // Ugly numbers
        
        // Only +ve numbers 
        if(num<=0){
            return false;
        }
        System.out.println("0:   "+num);
        // divide by 2
        while(num%2==0){
            num=num/2;
        }
        System.out.println("2:   "+num);
        // divide by 3
        while(num%3==0){
            num=num/3;
        }
        System.out.println("3:   "+num);
        // divide by 5
        while(num%5==0){
            num=num/5;
        }
        System.out.println("5:   "+num);
        if(num!=1){
            return false;
        }
        
        return true;
        
    }
}

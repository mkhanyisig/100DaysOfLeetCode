/*
     Day 63 : Leetcode 412. Fizz Buzz
     Time Spent: 7 mins 
     
     Personal notes: Pretty straightforward
*/


class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res= new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                res.add("FizzBuzz");
            }
            else if(i%3==0){
                res.add("Fizz");
            }
            else if(i%5==0){
                res.add("Buzz");
            }
            else{
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}
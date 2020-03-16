/*
     Day 35: Leetcode 374. Guess Number Higher or Lower
     Time Spent: 10 mins
     
     Personal notes: Binary search approach
     
*/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // binary search
        // recursive
        int l=0;
        int r=n;
        int mid=l+(r-l)/2;
        
        if(guess(l)==0){
            return l;
        }
        if(guess(r)==0){
            return r;
        }
        
        while(l<=r){ // binary search
            System.out.println("l: "+l+"  r: "+r+"  mid: "+mid);
            mid= l+(r-l)/2;
            
            if(guess(mid)==0){
                return mid;
            }
            else if(guess(mid)==-1){// left BS
                r=mid-1;
            }
            else{// right BS
                l=mid+1;
            }
        }
        
        return mid;
         
    }
}
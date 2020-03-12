/*
     Day 32: K Messed Array Sort
     Time Spent: 22 mins
     
     Personal notes: Similar to insertion sort, but more optimised
     
*/


import java.io.*;
import java.util.*;

class Solution {

  static int[] sortKMessedArray(int[] arr, int k) {
    // your code goes here
    // 
    /*
      - start at first index
      - look to k - right elemensts , 
      - if any number is bigger than current, swap
      - loop to end of array
      -> [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
      [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
      [1, 2, 5, 4, 3, 7, 8, 6, 10, 9]
      [1, 2, 3, 4, 5, 7, 8, 6, 10, 9]
      [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
      
      
      // min heap priority que
      // add first k+1 elements to priority que
      // loop from i=k+1 to n -> add peek element from PQ too array index
      // poll pririty que
      // add arr i to priority que
      
      // iterate through priority que and add elements to array
      
      
    */
    
    // min heap
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    // add first k elements
    for(int i=0;i<k+1;i++){
      pq.add(arr[i]);
    }
    
    int index=0;
    
    for(int i=k+1;i<arr.length;i++){
      arr[index++]=pq.peek();
      pq.poll();
      pq.add(arr[i]);
    }
    
    //Iterator<Integer> itr= new pq.Iterator();
    
    while(pq.size()!=0){
      arr[index++]=pq.peek();
      pq.poll();
    }
    
    return arr;
    
  }

  public static void main(String[] args) {

  }

}
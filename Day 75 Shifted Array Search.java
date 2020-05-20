/*
     Day 75: Pramp Shifted Array Search
     Time Spent: 35 mins
     
     Personal notes: Binary search
*/


import java.io.*;
import java.util.*;

class Solution {

  static int shiftedArrSearch(int[] shiftArr, int num) {
      /*
      - find pivot 
      - search for val
      */
    
      int b=1;
      int pivot=0;
      while(b<shiftArr.length){
          if(shiftArr[b]<shiftArr[b-1]){
              pivot=b;
          }
          b+=1;
      }
      int start;
      int end;
      System.out.println("gets here");
      // binary search
      if(shiftArr[pivot]<num){
          start=pivot+1;
          end=shiftArr.length-1;
      }else if(shiftArr[pivot]>num){
          start=0;
          end=pivot-1;
      }else{
          if(shiftArr[pivot]==num){
              return pivot;
          }
          else{
              return -1;
          }
      }
      System.out.println(" start: "+start+"  end : "+end);
      System.out.println(pivot);
      int mid=0;
      while(end>=start){
          mid=start+((end-start)/2);
          if( shiftArr[mid]>num){
              end=mid-1;
          }else if(shiftArr[mid]<num){
              start=mid+1;
          }else{
              System.out.println("stuck");
              return mid;
          }
      }
      System.out.println(mid);
      if(shiftArr[mid]==num){
          return shiftArr.length-mid;
      }else{
          return -1;
      }
      
  }
  /*
  static int shiftedArrSearchA(int[] shiftArr, int num) {
    // your code goes here
    /*
    - sorted array
    - num -> 
    - find the offset
    
    
    - start off with n=-1
    - loop through array and see if it contains n,
      - if so return that index
      - otherwise n=-1
      
      lower bound and higher bound
        - if value is not within range, then return -1
        
        
    ** condition to either do BS on left or right array  
    [7,8,9,10, | 2] num=8
    
    min(num-arr[0],num-arr[arr.length-1]){
    
    }
    {
    
    }
    
    */
  /*
    int n=-1;
    
    int[] bst;
    int index=-1;
    
    if(Math.min(num-shiftArr[0],num-shiftArr[shiftArr.length-1])){
        // left BS
        
        // figure out bounds
        int i=0;
        while(shiftArr[i]<shiftArr.length){
            if(shiftArr[i-1]>shiftArr[i]){
                break;
            }
          i++;
        } 
        
      
        bst=subArray(shiftArr, 0,i);
        index=i;
        
    }
    else{
        // right BS
      
      
        // figure out bounds
        int i=shiftArr.length;
        while(shiftArr[i]>0){
            if(shiftArr[i-1]<shiftArr[i]){
                break;
            }
          i--;
        }  
      
        bst=subArray(shiftArrr,i,shiftArr.lenth);  
        index = i;
    }
    
    // do BST on subarray, if num doesnt exist, return -1
    
    
    
    int l = 0, r = bst.length - 1;
    /*
    while (l <= r) { 
          int m = l + (r - l) / 2; 

          // Check if x is present at mid 
          if (bst[m] == num) {
              
              n= index+m;
          }

          // If x greater, ignore left half 
          if (bst[m] < num) {
            
              l = m + 1; 
          }

          // If x is smaller, ignore right half 
          else{
            r = m - 1; 
          }
              
    } 
    */
  /*
  
        
    return n;
    
    
  }
  */
  public static void main(String[] args) {
      int[] arr={9, 12, 17, 2,3, 4, 5};
      int res=shiftedArrSearch(arr,3);
      System.out.println(res);
  } 

}
/*
     Day 58 : Pramp - Pancake Sort
     Time Spent: 38 mins 
     
     Personal notes: Still working on smooth transition from Pseudocode to actual code
*/




import java.io.*;
import java.util.*;
// Mkhanyisi 
// Wahab
class Solution {
  
  private static void flip(int[] arr, int i){
      //int dup= new int[arr.length];
    
      /*
      for(int i=(arr.length-1);i>(arr.length)/2;i--){
          int temp= arr[i];
          arr[i]=arr[arr.length-1-i];
          arr[arr.length-1-i]=temp;
      }
      */
     int temp, start = 0; 
    while (start < i) 
    { 
        temp = arr[start]; 
        arr[start] = arr[i]; 
        arr[i] = temp; 
        start++; 
        i--; 
    } 
  }
  
  private static int max(int[] arr, int idx){
    int mx=arr[0]; 
    int id=0;
    for(int i=0;i<=idx;i++){
        if(arr[i]>mx){
            mx=arr[i];
            id=i;
        }
        
    }
    return id;
  }
  
  
  static int[] pancakeSort(int[] arr) {
    // your code goes here
    /*
         flip- reverses the order of the first k elements
         
         [1, 5, 4, 3, 2]
         
         idx= 4
         
         mx= findMaxIdx(arr,idx)
         
         // move max to beginning of array
         flip(arr,mx)
         -> [5,1, 4, 3, 2]
         flip(arr,idx)
         -> [2,3,4,1,5]
         
         idx-=1;
         
         
         [1, 2, 4, 3, 5]
         
         
    */
    
    for(int i=arr.length-1;i>=1;i--){
        
      int idx=max(arr,i);      
      System.out.println(" idx:"+idx+"  i: "+i);
      if(idx!=i){// swap largest element to end of array
            //System.out.println("flips");
            flip(arr,idx);
            System.out.println("flip #1: "+Arrays.toString(arr));
            flip(arr,i);
            System.out.println("flip #2: "+Arrays.toString(arr));
      } 
      System.out.println("flipped: "+Arrays.toString(arr));
    }
    return arr;
    
    
  }

  public static void main(String[] args) {
    
    int[] ar=new int[5];
    
    ar[0]=1;
    ar[1]=5;
    ar[2]=4;
    ar[3]=3;
    ar[4]=2;
    
    int[] arr= pancakeSort(ar);
    System.out.println("result: "+Arrays.toString(arr));
  }

}


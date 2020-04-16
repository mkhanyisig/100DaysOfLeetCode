/*
     Day 64 : Pramp Move Zeros To End
     Time Spent: 20 mins 
     
     Personal notes: Gettin a constant memory solution
*/


import java.io.*;
import java.util.*;

class Solution {

	static int[] moveZerosToEnd(int[] arr) {
		// your code goes here
    
    /*
    O(n)
    
    zeros=0;
    //ArrayList res=new ArrayList();
    int count=0;
    for(int i=0;i<n;i++){
      if(arr[i]!=0){
        arr[count++]=arr[i];
      }
    }
    
    while(count<arr.length-1){
      arr[i]=0;
    }
    
    return arr;
    
    // add al non-zero to result
    for(i=0 to i<zeros){
      res.add(0);
    }
    
    
    return res.toArray()
    
    // improved space complexity
    
    arr
    
    // [1, 10, 0,  0, 7, 0]
    
    loop through arra
    int val=0;
    int write=arr.length-1;
    for(int i=1;i<arr.length;i++){
        if(arr[i]==0){// swap with last element
            
            arr[write]=arr[]
        }
    }
    
    */
    
    int count=0;
    for(int i=0;i<arr.length;i++){
      if(arr[i]!=0){
        arr[count++]=arr[i];
        //count+=1;
      }
    }
    
    while(count<arr.length){
      
      arr[count++]=0;
      
    }
    
    return arr;
	}

	public static void main(String[] args) {
	
	}
  
  /*
    vector<int> arr1 = arr;
    
  int readIndex = 0;  
  int writeIndex = 0;  
  while(readIndex <  arr1.size())
  {
    
    if (0 == arr1[readIndex])
    {
        ++readIndex;
    }
    else
    {
      swap(arr1[writeIndex],arr1[readIndex]);
      ++readIndex;
      ++writeIndex;
    }        
  }


  return arr1;
  */
  
}

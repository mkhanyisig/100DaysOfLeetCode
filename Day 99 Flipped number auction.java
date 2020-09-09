/*
     Day 98: Flipped number marker in auction 
     Time Spent: 45 mins 
     
     Personal notes: edge cases
*/




import java.io.*;
import java.util.*;

class Solution {
  
  public static ArrayList<Integer> flipped(){
      /*
      range => 1-650
      
      return list of numbers that need a marker
      
      *********
      
      0-9
      
      **** need marker ****
      
      flipped map
          0-> 0
          1->1
          8->8
          3-> 3
          
          9->6
          6->9
        
      
      sysmetric numbers
      0 1 8 3
      
      => 
      
      opposites
      
      6 9
      
      
      
      => 96 or 69 eliminate
      
      ***** no need for marker *****
      numbers that don't need marker
      2457
      
      181 => ambiguous
      
      
      
      */
    
      ArrayList<Integer> arr=new ArrayList();
    
      HashSet<Character> hs = new HashSet<>();
      
      
      // add numbers that need marker => ambiguous
      hs.add('0');
      hs.add('1');
      hs.add('3');
      hs.add('6');
      hs.add('8');
      hs.add('9');
      
      HashMap<Character,Character> map= new HashMap();
    /*
    flipped map
          0-> 0
          1->1
          8->8
          3-> 3
          
          9->6
          6->9
    */
    map.put('0','0');
    map.put('1','1');
    map.put('8','8');
    map.put('9','6');
    map.put('6','9');
    
      
      
    
      String s;
      char[] carr;
    char[] test;
      boolean add=true;
      for(int i=0;i<=650;i++){
          
          s= Integer.toString(i);
          carr=s.toCharArray();
          
          add=true;
          // first test ambiguous numbers
          for(int j=0;j<carr.length;j++){
              if(!hs.contains(carr[j])){
                  add=false;
              }
          }
          // second test: edge cases
          test=new char[carr.length];
          for(int k=0;k<carr.length;k++){
              test[k]=carr[k];
          }  
        
        
          for(int k=0;k<carr.length;k++){
              if(map.containsKey(carr[k])){
                //System.out.println(carr[k]+" -> "+map.get(carr[k]));
                test[k]=map.get(carr[k]);
              }
              
          }
          // check if arrays are equal
          boolean marker=true;
          for(int k=0;k<test.length;k++){
              if(carr[k]!=test[k]){
                  marker=false;
              }
          }
             
          if(add && marker==false){
              System.out.println(Arrays.toString(carr)+" -> "+Arrays.toString(test));
              arr.add(i);
          }
          
        
      }
        
       System.out.println("result: "+arr);
      return arr;
    
    
  }
  
  
  public static void main(String[] args) {
      System.out.println("Testing");
       flipped();
  }
}

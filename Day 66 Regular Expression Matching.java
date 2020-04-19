/*
     Day 66: Pramp Basic Regex Parser || Leetcode 10. Regular Expression Matching
     Time Spent: 35 mins
     
     Personal notes: 
     
*/



import java.io.*;
import java.util.*;

class Solution {
  
  static boolean isMatch(String text, String pattern) {
    // your code goes here
    /*
    if strings are exact match -> return true
    
    if(pattern.contains('.'||pattern.contains('*'))){
        if(text.length != pattern.length){
          return false;
        }
    }
    
    // reg expresion check
    char[] dp=text.toCharArray();
    
P     ""  a * c
    "" t  f f  f
    a  f  t t  f
    b  f  f t. f
    c  f. f f  t
    // text = "abc", pattern = "a.c"
    
    int i=0;
    
    int it=0;
    int ip=0;
    
    //1. text = "abbc", pattern = "ab*c"
    //2.  text = "abc", pattern = "a*c"  false 
    //3. text = "abbbbc", pattern = "ab*bc" false
    while(i<text.length){
    
        if(pattern[ip]=='.'){
            it++;
            ip++;
            i++;
        }
        else if(pattern[ip]=='*'){
            char c=text[it-1];
            while(text[it]==c){
                it++;
                i++;
            }
            ip++;
        }
        else if(text[it]!=pattern[ip]){
            return false;
        }
        
    }
    
    return true;
    
    
    */
    
    if(pattern.indexOf('.') < 0 && pattern.indexOf('*') < 0){
        if(text.length() != pattern.length()){
          return false;
        }
    }
    
    int i=0;
    
    int it=0;
    int ip=0;
    
    while(i<text.length()){
    
        if(pattern.charAt(ip)=='.'){
            it++;
            ip++;
            i++;
        }
        else if(pattern.charAt(ip)=='*'){
            char c=text.charAt(it);
            while(text.charAt(it)==c){
                it++;
                i++;
            }
            
            ip++;
            if(pattern.charAt(ip)==c){
              ip++;
            }
        }
        else if(text.charAt(it)!=pattern.charAt(ip)){
            return false;
        }
        i++;
        
    }
    
    return true;
    
  }

  public static void main(String[] args) {
      boolean res= isMatch("acd","ab*c");
      System.out.println(res);
  }

}
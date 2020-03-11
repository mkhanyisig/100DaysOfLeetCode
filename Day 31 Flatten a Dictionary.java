/*
     Day 31: Flatten a Dictionary
     Time Spent: 35 mins
     
     Personal notes: Dictionary
     
*/



import java.io.*;
import java.util.*;

class Solution {
	
    
  
  
  
  public HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    // your code goes here
    // MK
    // Alex
    
    
    // loop through all keys of dict
      // if value type is string, add that to flat dictionary
      // if value in dictionary is an object type , append prefix to subkeys
    
    // return main dictionary
    
    
    
    //helper method for recursion
      // method accepts: (HashMap, currentKey)
      // functionality: updates the existing flattened_dict w/ the contents of hashMap
    
    // for every key,value pair in a dictionary:
      // if the value is a string or int -> just add it to flattened_dict
      // if the value is a Dictionary, call helper(dictaionary, key)
    
    
    
      
    HashMap<String, String> flat_dict = new HashMap<String, String>();
    helper("",dict,flat_dict);
    return flat_dict;
  }
  
  public void helper(String prev_key, HashMap<String, Object> dict, HashMap<String, String> flat_d){
    // recursive function
    
    for(String key: dict.keySet()){   
        if(dict.get(key) instanceof String){
            if(prev_key!=null || prev_key!=""){
              flat_d.put(key,(String) dict.get(key));
            }
            else{
              flat_d.put(prev_key+"."+key,(String) dict.get(key));
            }  
        } 
      
        else if(dict.get(key) instanceof Object){    
            for (String c: (HashSet<String>) dict.get(key).keySet()){
                helper(prev_key+"."+key,dict,flat_d);
                //Object obj = dict.get(key).remove(c);
                //dict.get(key).put(key+"."+c, obj);   
            }
            
            //flattenDictionary(dict.get(key));
        }
      
      
    }
  }

  public static void main(String[] args) {
    /*  
    HashMap<String, Object> dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }
     */
    //flattenDictionary(dict);
    
  }

}
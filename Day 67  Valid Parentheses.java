/*
     Day 67:  Leetcode 20. Valid Parentheses
     Time Spent: 35 mins
     
     Personal notes: Understanding stack DS
     
*/

class Solution {
    public boolean isValid2(String s) { // 63 / 76 test cases passed.
        if(s.length()==0){// empty string
            return true;
        }
        int i=0;
        HashMap<Character,Character> map= new HashMap();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        boolean res=true;
        while(i<s.length()){// for each, check pair match
            if(map.containsKey(s.charAt(i))){
                // check match
                boolean match=false;
                for(int j=i+1;j<s.length();j++){
                    if(s.charAt(j)==map.get(s.charAt(i))){
                        match=true;
                    }
                    
                    
                }
                if(match==false){
                    res=false;
                }
            }
            i+=1;
        }
        return res;
    }
    
    public boolean isValid(String s) { 
        if(s.length()==0){// empty string
            return true;
        }
        if(s.length()==1){
            return false;
        }
        Stack<Character> stack1 = new Stack<>();
        int i=0;
        HashMap<Character,Character> map= new HashMap();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        boolean res=true;
        while(i<s.length()){
            if(map.containsKey(s.charAt(i))){
                stack1.push(s.charAt(i));
            }else{
                if (stack1.isEmpty()) return false;
                else if (map.get(stack1.peek()) != s.charAt(i)) return false;
                else stack1.pop();
            }   
            i+=1;
        }
        //if (!stack1.isEmpty()) return false;
        return stack1.isEmpty();
    }
        
}
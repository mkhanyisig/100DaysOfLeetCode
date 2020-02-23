/*
     Day 16: Leetcode 389. Find the Difference
     Time Spent: 50 mins
     
     Personal notes: hash map data structure and how it works. Most of the time spent mostly debugging
*/


class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> mapA = new HashMap();
        HashMap<Character,Integer> mapB = new HashMap();
        
        for(int i=0;i<s.length();i++){
            if(mapA.containsKey(s.charAt(i))){
                mapA.put(s.charAt(i),mapA.get(s.charAt(i))+1);
            }
            else{
                mapA.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(mapB.containsKey(t.charAt(i))){
                mapB.put(t.charAt(i),mapB.get(t.charAt(i))+1);
            }
            else{
                mapB.put(t.charAt(i),1);
            }
        }
        System.out.println("mapA :\n"+Arrays.toString(mapA.entrySet().toArray()));
        System.out.println("\n\n mapB :\n"+Arrays.toString(mapB.entrySet().toArray()));
        /*
        char c=t.charAt(0);
        System.out.println(" zero "+c+" size: "+set.size());
        for(int j=0;j<t.length();j++){
            if(set.contains(t.charAt(j))==false){
                c=t.charAt(j);
                System.out.println(c);
                
            }
        }
        */
        
        char c=t.charAt(0);
        for(Character m:mapB.keySet()){
            if(!mapA.containsKey(m)){
                return m;
            }
            //System.out.println(" m:"+m+" map A: "+mapA.get(m)+"  map B: "+mapB.get(m));
            if(mapB.get(m)==null || mapA.get(m)==null){
                continue;
            }
            if(!mapB.get(m).equals(mapA.get(m))){
                c=m;
                System.out.println(c);
            }                
        }
        return c;
        
    }
}

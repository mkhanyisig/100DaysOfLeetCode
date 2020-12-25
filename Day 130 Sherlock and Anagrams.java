/*
     Day 130: Hackerank => Dictionaries and HashMaps: Sherlock and Anagrams

     Time Spent: 28 mins 
     
     Personal notes: Surprisingly I got right
*/

static int sherlockAndAnagrams(String s) {
        List<HashMap<Character,Integer>> l= new ArrayList<HashMap<Character,Integer>>();
        int result=0;
        
        // loop through all substring lengths
        for(int i=1;i<s.length();i++){ // substring length
            l=new ArrayList<HashMap<Character,Integer>>();
            
            for(int j=0;j<=s.length()-i;j++){
                String substr=s.substring(j, j+i);
                System.out.println(substr);
                HashMap<Character,Integer> map=new HashMap<Character,Integer>();
                for(char c:substr.toCharArray()){
                    map.put(c,map.getOrDefault(c,0)+1);
                }
                for(HashMap hm:l){
                    if(hm.equals(map)){
                        result+=1;
                    }
                }
                l.add(map);
            }
        }
        
        return result;
    }
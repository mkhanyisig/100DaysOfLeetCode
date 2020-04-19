/*
     Day 68:  Leetcode 443. String Compression
     Time Spent: 50 mins
     
     Personal notes: modifying input array part of question I missed
     
*/


class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        
        ArrayList<Character> res= new ArrayList();
        int i=0;
        
        while(i<chars.length){
            
            Character c= chars[i];
            System.out.println(c+"  i:"+i);
            int j=i;
            int cnt=0;
            while(c==chars[j] && j<=chars.length-1 && i<= chars.length-1){
                cnt+=1;
                j+=1;
                //i+=1;
                if(j==chars.length){
                    break;
                }
            }
            res.add(c);
            System.out.println(cnt);
            String s=Integer.toString(cnt);
            char[] in=s.toCharArray();
            if(cnt>1){
                for(int p=0;p<in.length;p++){
                    res.add(in[p]);
                }
            }
            
            i+=cnt;
            
        }
        System.out.println(Arrays.toString(res.toArray()));
        int size=res.size();
        
        char[] resc= new char[res.size()];
        
        for(int k=0;k<res.size();k++){
            char a=res.get(k);
            resc[k] = a;
        }
        // modify input array
        for(int m=0;m<resc.length;m++){
            chars[m]=resc[m];
        }
        
        
        if(size<=chars.length){
            chars=resc;
            return size;
            //return 4
        }
        else{
            return chars.length;
        }
        
    }
}
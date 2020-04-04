/*
     Day 52: Leetcode 461. Hamming Distance
     Time Spent: 22 mins 
     
     Personal notes: Converting decimal to binary 32-bit binary string was what took most of my time
*/


class Solution {
    public int hammingDistance(int x, int y) {
        
        String xs= "00000000000000000000000000000000";
        int k=xs.length()-1;
        while(x!=0){
            char a[]=xs.toCharArray();
            a[k--]= String.valueOf(x%2).charAt(0);
            xs=new String(a);
            x=x/2;  
        }
        String ys= "00000000000000000000000000000000";
        k=ys.length()-1;
        while(y!=0){
            char a[]=ys.toCharArray();
            a[k--]= String.valueOf(y%2).charAt(0);
            ys=new String(a);
            y=y/2;  
        }
        
        int a=0;
        System.out.println(xs+"   *   "+ys );
        for(int i=0;i<xs.length();i++){
            //char c=xs.charAt(i);
            //char d=ys.charAt(i);
            //boolean res= c.equals(d);
            if(xs.charAt(i)!=ys.charAt(i)){
                a+=1;  
            }
        }    
        return a;
        
    }
}
/*
     Day 83: Leetcode 223. Rectangle Area
     Time : 39 mins
     
     Personal notes: figuring out robust solution for determining intersection coords
*/


class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        /*
        Area rect -> 1
        w*h
        w=Math.abs(A-C)
        h=Math.abs(B-D)
        
        Area rect -> 2
        w*h
        w=Math.abs(G-E)
        h=Math.abs(H-F)
        
        Intersection rect-> Subtract
        y intersetction length -> h
        x intersection length -> w
        blx=Math.max(A,E)
        bly=Math.max(B,F)
        
        trx=Math.min(C,G)
        trry=Math.min(D,H)
        
        //if no intersection
        if(blx>=tlx || bly>=trry){
            y=0;
            x=0;
        }
        // else
        else{
            w=Math.abs(trry-bly);
            h=Math.abs(trx-blx);
        }
        
        
        A1+A2-I
        
        
        */
        
        //Area rect -> 1
        //w*h
        int wa1=Math.abs(A-C);
        int ha1=Math.abs(B-D);
        
        //Area rect -> 2
        //w*h
        int wa2=Math.abs(G-E);
        int ha2=Math.abs(H-F);
        
        // Intersection area
        int blx=Math.max(A,E);
        int bly=Math.max(B,F);
        
        int trx=Math.min(C,G);
        int trry=Math.min(D,H);
        
        int wint;
        int hint;
        //if no intersection
        if(blx>=trx || bly>=trry){
            hint=0;
            wint=0;
        }
        // else
        else{
            wint=Math.abs(trry-bly);
            hint=Math.abs(trx-blx);
        }
        
        int a1=(wa1*ha1);
        int a2=(wa2*ha2);
        int sect=(hint*wint);
        
        int area=a1+a2-sect;
        
        System.out.println(a1+"   "+a2+"   "+sect+"    "+area);
        
        return area;
        
    }
}
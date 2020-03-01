/*
     Day 23: Leetcode 447. Number of Boomerangs
     Time Spent: 54 mins
     
     Personal notes: Had the right idea with and HAshSet earlier (22/31 test cases)and Hashmap succesful soln
*/


class Solution {
    public int nCr(int n, int r) { 
        return fact(n) / (fact(r) * fact(n - r)); 
    } 
    
    public int nPr(int n, int r) { 
        if(n<r){// just for this case
            return n*(n-1);
        }
        return fact(n) / (fact(n - r)); 
    } 
  
    // Returns factorial of n 
    public static int fact(int n) { 
        int res = 1; 
        for (int i = 2; i <= n; i++) 
            res = res * i; 
        return res; 
    } 
    
    
    public int numberOfBoomerangs(int[][] points) {
        // loop through each element in list and claculate distances
         int res=0; 
        int n =0;
        int t=0;
        Double d=0.0;
        HashSet<Double> h = new HashSet<Double>();
        Map<Double, Integer> map = new HashMap<>();
        for(int i=0;i<points.length;i++){
            h=new HashSet<Double>();
            
            for(int j=0;j<points.length;j++){
                if(i==j){
                    continue;
                }
                int x1=points[i][0]; 
                int y1=points[i][1];
                int x2=points[j][0]; 
                int y2=points[j][1];     
                d=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
                map.put(d, map.getOrDefault(d, 0) + 1);
                if(!h.add(d)){
                    System.out.println("("+x1+","+y1+") * ("+x2+","+y2+")");
                    
                    t+=1;
                }
            }   
            
            for(int val : map.values()) {
                res += nPr(val,2);
            }    
            
            
            if(t>0){
                System.out.println(t);
                t+=1;
                n+= (fact(t) / (fact(t - 2)));
            }
            map.clear();
            t=0;
        }
        
        
        System.out.println("res "+res);
        
        return res;
    }
}

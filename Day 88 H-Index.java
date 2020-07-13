/*
     Day 88: Leetcode 274. H-Index
     Time : 82 mins
     69 / 82 test cases passed.
     
     Personal notes: Translating psedosolution to working code. I didn't fully get the question. 
*/

// My code
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0 || citations==null){
            return 0;    
        }
        
        if(citations.length==1 && citations[0]>0){
            return 1;
        }
        
        if(citations.length==1 && citations[0]==0){
            return 0;
        }
        
        int N=citations.length;
        
        Arrays.sort(citations);
        
        int total=0;
        for(int i=citations.length-1;i>=0;i--){
            
            
            // number less than
            int less=0;
            int greater=0;
            for(int nt: citations){
                if(nt<citations[i]){
                    less+=1;
                }
                if(nt>=citations[i]){
                    greater+=1;
                }
            }
            int Nh=N-citations[i];
            
            System.out.println("lesser: "+less+"   cit:"+ citations[i]+"   NH: "+Nh+"  greater: "+greater);
            
            
            if(citations[i]<=greater){
                return citations[i];
            }
            
            
            /*
            System.out.println(citations[i]);
            total+=citations[i];
            if(N-citations[i]>=citations[i]){
            //if(total>=i){
                return i;
            }
            */
        }
        System.out.println("none");
        return citations.length;
    }
}

/*

The idea is to see that the result can only range from 0 to the length of the array (because we can't have h-index greater than the total 
papers published). So we create an array "arr" which acts like a HashMap (using pigeon hole principle) and loop backwards from the 
highest element, then we find "tot" which is the total number of papers that has more than i citations, and we stop when 
tot>=i (total number of papers with more than i citations >= i). We don't need to keep going because we are trying the biggest i possible,
 we we stop and return the result.

*/
 
public class Solution {
public int hIndex(int[] citations) {
    int n = citations.length, tot=0;
    int[] arr = new int[n+1];
    for (int i=0; i<n; i++) {
        if (citations[i]>=n) arr[n]++;
        else arr[citations[i]]++;
    }
    for (int i=n; i>=0; i--) {
        tot += arr[i];
        if (tot>=i) return i;
    }
    return 0;
}
}

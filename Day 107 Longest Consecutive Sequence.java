/*
     Day 106: Leetcode  128. Longest Consecutive Sequence
     Time Spent: 90 mins 
     
     Personal notes: Good intuition with Brute force but did'nt handle duplicate cases well. Should have used hashmap approach instead of trying to turn this into a graph problem
*/


// hashmap
/*
We will use HashMap. The key thing is to keep track of the sequence length and store that in the boundary points of the sequence. For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.

Whenever a new element n is inserted into the map, do two things:

See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n. Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later. Store (left + right + 1) as the associated value to key n into the map.
Use left and right to locate the other end of the sequences to the left and right of n respectively, and replace the value with the new length.
Everything inside the for loop is O(1) so the total time is O(n). Please comment if you see something wrong. Thanks.
*/
public int longestConsecutive(int[] num) {
    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : num) {
        if (!map.containsKey(n)) {
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            // sum: length of the sequence n is in
            int sum = left + right + 1;
            map.put(n, sum);
            
            // keep track of the max length 
            res = Math.max(res, sum);
            
            // extend the length to the boundary(s)
            // of the sequence
            // will do nothing if n has no neighbors
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        else {
            // duplicates
            continue;
        }
    }
    return res;
}




class Solution {   // Brute Force Intuition => 49 / 68 test cases passed. 
    public class Node{
        int val;
        Node next;
        
        public Node(int n){
            val=n;
        }
        
    }
    
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        Node[] narr= new Node[nums.length];
        
        
        HashSet<Integer> hs= new HashSet<>();
        
        for(int i=0;i<nums.length;i++){// build nodes
            narr[i]=new Node(nums[i]);
            hs.add(nums[i]);
        };
        
        for(int i=1;i<narr.length;i++){// connect 
            if(hs.contains(narr[i].val-1)){
                if(narr[i].val==narr[i-1].val){
                    narr[i]=narr[i-1];
                }else{
                    narr[i-1].next=narr[i]; 
                }
                  
            };
        };
        
        // count longest consecutive sequence
        int pos=0;
        int clen=1;
        int max_len=0;
        int prev=Integer.MIN_VALUE;
        while(pos < narr.length){
            //System.out.println("Node val "+narr[pos].val+"    chain length "+clen);
            if(narr[pos].val==prev){
                //System.out.println("pass : "+narr[pos].val);
                System.out.println("node val : "+narr[pos].val+"   next: "+narr[pos].next+"  clen : "+clen+"** (pass)");
                //clen+=1;
                System.out.println("clen: "+clen);
                prev=narr[pos].val;
                
            }
            else if(narr[pos].next != null){
                System.out.println("node val : "+narr[pos].val+"   next: "+narr[pos].next.val);
                clen += 1;  
                prev=narr[pos].val;
            }else{
                System.out.println("\n\nnode val : "+narr[pos].val+"   next: "+narr[pos].next+"  *end\n\n");
                //clen+=1;
                if(max_len < clen){
                    max_len = clen;
                }
                clen=1;
                prev=narr[pos].val;
            };
            
            pos+=1;
        }
       
        return max_len;
        
        
    }
}

/*
     Day 45: Leetcode 414. Third Maximum Number
     Time Spent: 59 mins
     
     
     Personal notes: This suprisingly took me longer than I expected
     
*/


import java.lang.*;
class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                pq.offer(i);
                if (pq.size() > 3) set.remove(pq.poll());
            }
        }
        if (pq.size() == 2) pq.poll();
        return pq.peek();
        
    }
    public int thirdMax2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        
        
        
        //nums=b;
        
        
        Stack<Integer> pq = new Stack<>(); 
        HashSet<Integer> h = new HashSet<Integer>();
        int i=nums.length-1;
        int j=0;
        while(pq.size()<=3 && i>=0){
            
            if(!h.contains(nums[i])){
                System.out.println(nums[i]);
                pq.push(nums[i]);
                h.add(nums[i]);
                i-=1;
                j+=1;
            }else{
                j+=1;
                i-=1;
            }
            
        }
        System.out.println("stack:  "+pq+" hs: "+h.size()+"  pq : "+pq.size());
         
        if(h.size()==3 && pq.size()==3){
            System.out.println(1);
            return pq.pop();
        }
        else if(h.size()==2 && pq.size()==2){
            System.out.println(2);
            System.out.println("poll: "+pq.pop());
            return pq.pop();
        }
        else if(h.size()==1 ){
            System.out.println(3);
            
            return pq.pop();
        }
        else{
            return pq.pop();
        }
    }
}
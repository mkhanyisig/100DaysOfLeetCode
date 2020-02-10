/*
     Day 2: Leetcode 206. Reverse Linked List
     Time Spent: 18 mins
     
     Personal notes: 
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> el = new ArrayList<Integer>(); 
        
        // add all elements to arraylist
        int size=0;
        while(head!=null){
            el.add(head.val);
            head=head.next;
            size+=1;
        }
        
        // quality check : All elements added
        /*
        System.out.println("Print list");
        for(int i=0;i<el.size();i++){
            System.out.println(el.get(i));
        } 
        */
        // build new list and reverse it
        ListNode l = new ListNode(-1); // intialize with dummy value
        ListNode h = l;
        for(int i=size-1;i>=0;i--){
            l.next = new ListNode(el.get(i));
            l=l.next;
        }
        
        return h.next;
    }
}
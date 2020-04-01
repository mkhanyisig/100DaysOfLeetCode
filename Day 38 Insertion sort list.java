/*
     Day 38: Leetcode 147. Insertion Sort List
     Time Spent: 16 mins 
     
     Personal notes: Swaping values took me the longest to figure out
     
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
    public ListNode insertionSortList(ListNode head) {
        ListNode h = head;
        ListNode ptr= h;
        while(h!=null){
            int v=h.val;
            //int min = h.val;
            while(ptr!=null){
                if(ptr.val<v){
                    //swap
                    h.val=ptr.val;
                    //v= ptr.val;
                    ptr.val=v;
                    v=h.val;
                    
                }
                ptr=ptr.next;
            }
            ptr=h.next;
            h=h.next;
        }
        return head;
    }
}
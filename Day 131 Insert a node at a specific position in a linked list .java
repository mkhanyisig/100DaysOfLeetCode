/*
     Day 131: Hackerank => Insert a node at a specific position in a linked list


     Time Spent: 22 mins 
     
     Personal notes: Subtle bug
*/

static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        
        SinglyLinkedListNode ptr=head;
        int i=0;
        
        while(i<position-1){
            ptr=ptr.next;
            i+=1;
        }
        System.out.println(i+" - "+position+" val: "+ptr.data);
        SinglyLinkedListNode n= new SinglyLinkedListNode(data);
        
        n.data=data;
        n.next=ptr.next;
        ptr.next=n;
        System.out.println(ptr.data); 
        return head;
}
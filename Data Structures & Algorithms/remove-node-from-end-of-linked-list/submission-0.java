/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Edge Cases
        if(head.next == null){
            return null;
        }

        ListNode dummy, l, r;
        dummy = new ListNode(0,head);       // Dummy node acts as insurance for problems that would be impossible if the left pointer starts at the head
        l = dummy;
        r = head;

        //Set the space apart between the left and right pointers
        while (n > 0 && r != null){
            r = r.next;
            n -= 1;
        }
        
        //Move while the right pointer isn't null
        while (r != null){
            l = l.next;
            r = r.next;
        }

        //remove nth node from end of the list
        l.next = l.next.next;
        return dummy.next;
    }
}

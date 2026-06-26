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
    public void reorderList(ListNode head) {
        //Head node remains the same
        //Last node becomes the 2nd node
        //From here we use the following pattern: L1, Ln-1, L2, Ln-2,...

        //Approach (Brute Force): 
        // Use prev to create a seperate list while keeping head the same
        // Start by iterating to the last node and appending it to the new list
        // Begin the implementing the pattern

        // Before we continue we're just checking the logic here:
        // [1,2,3,4]
        // [4,3,2,1]
        // Result = [1,4,2,3]

        // [1,2,3,4,5]
        // [5,4,3,2,1]
        // Result = [1,5,2,4,3]

        // This problem is just simply adding a node from the original order and follows with a node in reverse order until they meet in the middle

        // Since we can't create a new linked list we need to have temp links before breaking them, 
        // We'll start by find the last node in the linked list using the slow and fast approach

        ListNode slow, fast;
        slow = fast = head;
 
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second, prev, temp;
        second = slow.next;
        prev = slow.next = null;

        //Establishes the pointer for the 2nd half of the list that's been reversed
        while (second != null){
            temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode temp1, temp2, first;
        first = head;                   //[1,2,3]   ,[1,2,3]
        second = prev;                  //[4]       ,[5,4]
        while (second != null){
            temp1 = first.next;         //[2,3]     ,[2,3]      -> [3]
            temp2 = second.next;        //null      ,[4]        -> null

            first.next = second;        //[1,4]     ,[1,5]      -> [1,5,2,4] 
            second.next = temp1;        //[1,4,2,3] ,[1,5,2,3]  -> [3]

            first = temp1;              //[2,3]     ,[2,3]      -> [3]
            second = temp2;             //null      ,[4]        -> [null]
        }
    }
}

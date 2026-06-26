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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Goal add values of each curr node from each list together and create a new list containing the sum

        //Step 1: Create nodes to point to each list and boolean value to deal with carrying a 1 over to the next sum
        ListNode head, tail, curr1, curr2;
        head = new ListNode(0);
        tail = head;
        curr1 = l1;
        curr2 = l2;
        int carry = 0;
        int sum = 0;

        //Step 2: Create a while loop that keeps going until both lists have been fully traversed
        while(curr1 != null || curr2 != null || carry != 0){
            sum = 0;
            if(curr1 != null){              //List1 not empty: keep going
                sum += curr1.val;
                curr1 = curr1.next;
            }
            if(curr2 != null){              //List2 not empty: keep going
                sum += curr2.val;
                curr2 = curr2.next;
            }
            sum += carry;                   //Add carry if any from previous sum
            carry = sum / 10;               //Find carry for next sum
            sum %= 10;                      //Ensure the sum is less than 10
            tail.next = new ListNode(sum);  //Create a new node
            tail = tail.next;               //Make it the next node
        }
        //Step 3: Return the list
        return head.next;
    }
}

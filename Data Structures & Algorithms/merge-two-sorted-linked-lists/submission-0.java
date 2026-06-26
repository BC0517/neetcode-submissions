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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                if (list1 == null && list2 == null){
            return null;
        } else if(list1 == null){
            return list2;
        } else if (list2 == null){
            return list1;
        } 
        
        ListNode prev, curr1, curr2, result;
        prev = null;
        curr1 = list1;
        curr2 = list2;

        //Find head of new Linked List
        if(curr1.val <= curr2.val){
            result = prev = curr1;
            curr1 = curr1.next;
        } else {
            result = prev = curr2;
            curr2 = curr2.next;
        }
        //curr1: null
        //curr2: [4]
        //result:[1,1,2,3,4]

        //Add nodes to list
        while(curr1 != null || curr2 != null){ 
            if(curr1 == null || curr2 ==null){
                break;
            }
            if(curr1.val <= curr2.val){
                prev.next = curr1;
                prev = prev.next;
                curr1 = curr1.next;
            } else {
                prev.next = curr2;
                prev = prev.next;
                curr2 = curr2.next;
            }
        }

        //Add last node
        if(curr1 != null){
            prev.next = curr1;
            prev = prev.next;
            curr1 = curr1.next;
        } else{
            prev.next = curr2;
            prev = prev.next;
            curr2 = curr2.next;
        }

        return result; 
    }
}
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
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> seen = new HashSet<>();
        
        while (curr != null){
            seen.add(curr);
            curr = curr.next;
            if(seen.contains(curr)){
                return true;
            }
        }
        return false;
    }
}

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
    public ListNode mergeKLists(ListNode[] lists) {
        // A PQ will automatically reorder inserted values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));

        ListNode result = null;
        ListNode tail = result;
        //Filter out empty lists
        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();  // Smallest list node gets polled
            if(result == null){
                result = smallest;          // initialize list with smallest List Node
            } else {
                tail.next = smallest;       // Set the next smallest node to the end of the list
            }
            tail = smallest;                // Update tail to equal the next smallest node
            
            if(smallest.next != null){
                pq.add(smallest.next);      // Add the other nodes to the pq to get sorted
            }
        }
        return result;
    }
}

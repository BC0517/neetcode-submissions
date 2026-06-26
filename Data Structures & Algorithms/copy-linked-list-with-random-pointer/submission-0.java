/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //Goal: Create a Deep copy of the original list including random pointer

        //Step 1: Create a hashmap to pair the original node with the newly created copy
        Map<Node,Node> map = new HashMap<>();

        //Step 2: Iterate through the list to create copies of each node
        Node curr = head;
        while (curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        //Step 3: Assign each copied node their next and random pointers
        curr = head;
        while (curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        curr = head;
        return map.get(curr);
    }
}

class LRUCache {
    int cap;
    Map<Integer, Node> map;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();

        left = new Node(0,0);
        right = new Node(0,0);

        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node curr = map.get(key);
        remove(map.get(key));
        insert(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
            map.remove(key);
        }

        Node newNode = new Node(key,value);
        map.put(key,newNode);
        insert(newNode);

        if(map.size() > cap){
            Node lru = left.next;
            lru.prev.next = lru.next;
            lru.next.prev = left;
            map.remove(lru.key);
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        node.next = right;
        node.prev = right.prev;
        right.prev.next = node;
        right.prev = node;
    }
}
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node (int key, int val){
        this.key = key;
        this.value = val;
    }
}
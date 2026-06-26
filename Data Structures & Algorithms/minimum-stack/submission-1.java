class MinStack {
    private Stack<Integer> stack;
    private PriorityQueue<Integer> minHeap;

    public MinStack() {
        stack = new Stack<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.push(val);
        minHeap.add(val);
    }
    
    public void pop() {
        minHeap.remove(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}

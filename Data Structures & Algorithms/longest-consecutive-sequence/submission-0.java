class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {return 0;}

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int len = 1;
        int max = 1;

        for(int num : nums){
            minHeap.add(num);
        }

        int prev = minHeap.poll();
        while (!minHeap.isEmpty()) {
            int curr = minHeap.poll();
            if (curr == prev) {
                continue;
            } else if (curr - prev == 1) {
                len++;
            } else {
                len = 1;
            }
            max = Math.max(max, len);
            prev = curr;
        }
        return max;
    }
}

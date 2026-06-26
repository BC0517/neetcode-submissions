class Solution {
    public int largestRectangleArea(int[] heights) {
        //The largest rectangle can span across multiple bars
        //The rectangle must be formed using the smallest available value that fits with bars next to it
        //If no large rectangles can be formed, the largest value in the height array is returned
        if(heights.length == 0){
            return 0;
        } else if (heights.length == 1){
            return heights[0];
        }

        int maxArea = 0;
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop(); //popping largest bars
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index)); //save maxArea
                start = index;
            }
            stack.push(new int[]{start,heights[i]});
        }

        //reach the end of the array of bars
        //find the maxArea from rectangles in the stack
        for(int[] rec : stack){
            int index = rec[0];
            int height = rec[1];
            maxArea = Math.max(maxArea, height * (n - index));
        }

        return maxArea;
    }
}

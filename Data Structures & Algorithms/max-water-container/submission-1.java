class Solution {
    public int maxArea(int[] heights) {
        //Similar to finding maxArea of a rectangle
        //Calculate area of each rectangle found from the pointers
        //Length: r - l, height: smallest value between height[l] and height[r]
        //Save the highest value
        //stop when they meet in the middle

        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;

        while(l < r){
            int area =  Math.min(heights[r], heights[l]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if(heights[l] < heights[r]){
                l++;
            } else if (heights[l] > heights[r]){
                r--;
            } else{
                l++;
                r--;
            }
        }
        return maxArea;
    }
}

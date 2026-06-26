class Solution {
    public int trap(int[] height) {
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        int[] minHeight = new int[height.length];
        int result = 0;
        int l = 0;
        int r = height.length - 1;

        //find max height of each position's left pointer
        for(int i = 0; i < height.length; i++){
            if(height[i] < height[l]){
                maxL[i] = height[l];
            } else{
                maxL[i] = height[i];
                l = i;
            }
        }
        //find max height of each position's right pointer
        for(int i = height.length - 1; i >= 0; i--){
            if(height[i] < height[r]){
                maxR[i] = height[r];
            } else{
                maxR[i] = height[i];
                r = i;
            }
        }
        //find min hieght of each position between both pointers
        for(int i = 0; i < height.length - 1; i++){
            minHeight[i] = Math.min(maxL[i],maxR[i]);
        }
        //find height of each position
        for(int i = 0; i < height.length - 1; i++){
            result += minHeight[i] - height[i];
        }
        
        return result;
    }
}

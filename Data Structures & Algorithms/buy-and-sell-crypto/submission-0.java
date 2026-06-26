class Solution {
    public int maxProfit(int[] prices) {
        /** 
        Use left and right pointers to keep track of low cost values
        Keep track of the max profit between pointers
        */
        int l = 0;
        int r = 1;
        int maxP = 0;
        while (r < prices.length){
            //If profit is found determine if it's a new maxP otherwise set the buy pointer to r
            if(prices[l] < prices[r]){
                int profit = prices[r]-prices[l];
                maxP = Math.max(maxP, profit);
            } else{
                l = r;
            }
            r++;
        }
        return maxP;
    }
}

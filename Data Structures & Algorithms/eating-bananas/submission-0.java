class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();  // Get max value of array
        int rate = r;

        while (l <= r){
            int k = l + (r - l) / 2;
            int hrs = 0;
            for (int p : piles){
                hrs += Math.ceil((double)p / k);    // Collect total hrs it takes for eat rate 
            }
            if(hrs > h){
                l = k + 1;
            }
            if(hrs <= h){
                r = k - 1;
                rate = k;
            }
        }
        return rate;
    }
}

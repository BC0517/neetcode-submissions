class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //output array is already in increasing order
        //returned pair can't be the same number
        //no additional memory should be used
        int l = 0;
        int r = numbers.length - 1;
        
        int sum = 0;
        while (l < r){
            sum = numbers[l] + numbers[r];
            if(sum == target){
                break;
            }
            if(l < r && sum < target){
                l++;
            }else{
                r--;
            }       
        }
        return new int[]{l+1,r+1};
    }
}

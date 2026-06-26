class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[l];

        while (l <= r){
            if (nums[l] < res){
                res = Math.min(res, nums[l]);
                break;
            }
            int mid = l + (r - l) / 2;
            if(nums[mid] < res){
                res = Math.min(res, nums[mid]);
            }
            if (nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return res;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){               //If the value at mid is smaller save it
                return mid;
            }
            if (nums[l] <= nums[mid]){
                if (target > nums[mid] || target < nums[l]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[r]){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}

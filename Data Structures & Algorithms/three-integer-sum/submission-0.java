class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        //Sort the list
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){ //loop stops at 2nd to last place for 3 value combinations
            if(i > 0 && nums[i] == nums[i - 1]){ //checks if previous value is a duplicate then skips current iteration
                continue;
            }
            int l = i + 1; //left pointer is always i + 1 at the start of an iteration
            int r = nums.length - 1; //right pointer remains the same

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(l < r && sum < 0){
                    l++;
                } else if (r > l && sum > 0){
                    r--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    result.add(temp);
                    l++;
                    r--;

                    //Check if previous left pointer is a duplicate value
                    while (l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                    //Check if previous right pointer is a duplicate value
                    while (r > l && nums[r] == nums[r + 1]){
                        r--;
                    }
                }
            }
        }

        return result;
    }
}

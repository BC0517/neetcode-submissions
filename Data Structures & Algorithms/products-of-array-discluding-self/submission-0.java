class Solution {
    public int[] productExceptSelf(int[] nums) {
        //The val of output[1] in the output array is the product of every val in nums except nums[1]
        //Simple approach: use a nested loop to get the product of every value except nums[i]
        //Cons int[] nums can be long, need a quicker solution O(n)
        // 3 pointers, i,j,k
        //i moves through nums, j stays on the point that needs to be avoided and increments when i reaches nums.length
        //k stays on result index and increments when product is added

        int[] result = new int[nums.length];
        Arrays.fill(result,1);

        int prefix = 1;
        for(int i = 0; i < result.length; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i = result.length-1; i >= 0; i--){
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}  

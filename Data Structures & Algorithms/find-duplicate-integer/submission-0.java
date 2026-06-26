class Solution {
    public int findDuplicate(int[] nums) {
        //Goal: return the integer being repeated

        //Approach: Use a set and traverse the array, return when a duplicate is found
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            if(!set.contains(num)){
                set.add(num);
            } else {
                return num;
            }
        }
        return -1;
    }
}

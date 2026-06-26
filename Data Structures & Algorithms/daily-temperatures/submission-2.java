class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Keep counting until temp at temperature[i] finds a warmer temp, store count in result[i]
        //temp[i] > temp[j] -> count++
        //i == j -> continue;
        //Brute force approach
        int[] result = new int[temperatures.length];

        int count = 0;
        for(int i = 0; i < temperatures.length; i++){
            count = 0;
            for(int j = i + 1; j < temperatures.length; j++){
                count++;
                if(temperatures[j] > temperatures[i]){
                    result[i] = count;
                    break;
                }
            }
        }
        return result;

    }
}

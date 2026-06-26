class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0){
            return 0;
        }
        double[][] cars = new double[position.length][2];

        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i]; //position
            cars[i][1] = (double)(target - position[i]) / speed[i]; //time to reach destination
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // Sort in descending order

        int count = 0;
        double prevTime = 0;
        for(double[] car : cars){
            if(car[1] > prevTime){ //arrival is longer than previous car
                count++;
                prevTime = car[1];
            }
        }

        return count;

    }
}

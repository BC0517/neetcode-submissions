class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0){
            return 0;
        }
        int[][] cars = new int[position.length][2];
        Stack<Double> stack = new Stack<>(); 

        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i]; //position
            cars[i][1] = speed[i]; //speed
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0])); // Sort in descending order
        
        for(int[] car : cars){
            stack.push((double)(target - car[0]) / car[1]);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){ //arrival is longer than previous car
                stack.pop();
            }
        }

        return stack.size();

    }
}

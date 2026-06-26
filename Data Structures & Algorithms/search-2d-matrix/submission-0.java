class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;                   // total rows
        int cols = matrix[0].length;                // total cols

        int top = 0;                                // top row
        int bot = rows - 1;                         // bot row

        while (top <= bot){
            int row = (top + bot) / 2;              // find current row
            if(target > matrix[row][cols - 1]){     
                top = row + 1;                      // If the target is greater than the row's last value then increment the top row
            }
            else if(target < matrix[row][0]){
                bot = row - 1;                      // If the target is less than the row's first value then decrement the bot row
            }
            else {
                break;
            }
        }

        if (top > bot){
            return false;
        }
        // Now that you found the row with the value, use Binary search for find the target value
        int row = (top + bot)/2;
        int l = 0;
        int r = cols - 1;

        while (l <= r){
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] > target){
                r = mid - 1;
            } 
            else if (matrix[row][mid] < target){
                l = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

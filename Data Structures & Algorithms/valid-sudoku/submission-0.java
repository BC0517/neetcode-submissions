class Solution {
    public boolean isValidSudoku(char[][] board) {
        //rows can't have duplicates
        //columns can't have duplicates
        //numbers 1-9 must be filled throughout 9x9 square
        //board is partially filled with # strings, the rest are filled with "."
        //A Set for each row and column can be used to make sure there are no duplicates
        //A hashMap for for each 3x3 square to determine if there are any duplicates inside
        //A hashmap with the square coordinates as the key and a hashMap as the value
        Map<Integer,Set<Character>> col = new HashMap<>();
        Map<Integer,Set<Character>> row = new HashMap<>();
        Map<String,Set<Character>> sqr = new HashMap<>();

        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                String sqrKey = (r/3) + "," + (c/3);
                if(board[r][c] == '.'){
                    continue;
                }
                else if(col.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) || 
                        row.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) || 
                        sqr.computeIfAbsent(sqrKey, k -> new HashSet<>()).contains(board[r][c])){
                    return false;
                }
                col.get(c).add(board[r][c]);
                row.get(r).add(board[r][c]);
                sqr.get(sqrKey).add(board[r][c]);
            }
        }
        return true;
    }
}

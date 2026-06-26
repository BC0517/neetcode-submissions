class Solution {
    public List<String> generateParenthesis(int n) {
        //generate all n possible valid parenthesis combinations
        //If # of open parenth == # of closed parenth, add values in stack to list
        //If # of open < n, add 1 open parenth, call method , pop string in stack
        //If # of close < open, add 1 close, call method, pop string in stack
        //Return list of strings
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();

        backTracking(0,0,n,res,stack);
        return res;
    }

    private void backTracking(int open, int closed,int n, List<String> res, StringBuilder stack){
        if(open == closed && closed == n){
            res.add(stack.toString());
            return;
        }
        if(open < n){
            stack.append('(');
            backTracking(open + 1,closed,n,res,stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if(closed < open){
            stack.append(')');
            backTracking(open,closed + 1,n,res,stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}

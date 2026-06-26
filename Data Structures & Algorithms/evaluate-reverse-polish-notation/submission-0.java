class Solution {
    public int evalRPN(String[] tokens) {
        //Place all string in stack
        //If an operand is found then the calcuation will be carried out by popping all values in the stack
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int temp1 = 0, temp2 = 0;

        
        for(String s : tokens){
            if(s.equals("+")){
                temp1 = stack.pop();
                temp2 = stack.pop();
                result = temp2 + temp1;
                stack.push(result);
            } else if(s.equals("-")){
                temp1 = stack.pop();
                temp2 = stack.pop();
                result = temp2 - temp1;
                stack.push(result);
            } else if(s.equals("*")){
                temp1 = stack.pop();
                temp2 = stack.pop();
                result = temp2 * temp1;  
                stack.push(result);
            } else if(s.equals("/")){
                temp1 = stack.pop();
                temp2 = stack.pop();
                result = temp2 / temp1;
                stack.push(result);
            } else{
                stack.push(Integer.parseInt(s));
            }
        } 
        return stack.pop();
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        //Place all string in stack
        //If an operand is found then the calcuation will be carried out by popping all values in the stack
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int a = 0, b = 0;

        
        for(String s : tokens){
            if(s.equals("+")){
                result = stack.pop() + stack.pop();
                stack.push(result);
            } else if(s.equals("-")){
                a = stack.pop();
                b = stack.pop();
                result = b - a;
                stack.push(result);
            } else if(s.equals("*")){
                result = stack.pop() * stack.pop();  
                stack.push(result);
            } else if(s.equals("/")){
                a = stack.pop();
                b = stack.pop();
                result = b / a;
                stack.push(result);
            } else{
                stack.push(Integer.parseInt(s));
            }
        } 
        return stack.pop();
    }
}

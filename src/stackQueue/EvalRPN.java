package stackQueue;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for(String token:tokens){
            if("+".equals(token)){
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a+b);
            }else if("-".equals(token)){
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a-b);
            }else if("*".equals(token)){
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a*b);
            }else if("/".equals(token)){
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a/b);
            }else{
                numbers.push(Integer.parseInt(token));
            }
        }
        return numbers.pop();
    }
}

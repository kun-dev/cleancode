/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are + - * /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2","1","+","3","*"] -> ((2+1)*3) -> 9
 * ["4","13","5","/","+"] -> (4+(13/5)) -> 6
 * The Reverse Polish Notation (RPN) is also known as the postfix notation, because
 * each operator appears after its operands. For example, the infix notation
 * "3+4" is express as "3 4 +"
 */
package _31_reversePolishNotation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author I300939
 */
public class ReversePolishNotation {
    /*
    Every time we see an operator, we need to evaluate the last two operands Stack
    fits perfectly as it is a Last-In-First-Out (LIFO) data structure.
    We evaluate the expression left-to-right and push operands onto the stack until
    we encounter an operator, which we pop the top two values from the stack. We
    then evaluate the operator, with the values as arguments and push the result
    back onto the stack.
    */
    private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    
    private int eval(int x, int y, String operator) {
        switch (operator) {
                case "+": return x+y;
                case "-": return x-y;
                case "*": return x*y;
                default: return x/y;
        }
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x,y,token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

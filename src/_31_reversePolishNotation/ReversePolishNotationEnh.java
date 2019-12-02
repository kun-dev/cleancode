/*
 * The previous code contains duplication. For example, if we decide to add a new
 * operator, we would need to update the code in two places - in the set's
 * initialization and the switch statement. In Java, create an interface called
 * Operator and map each operator string to an implementation of the Operator and
 * map each operator string to an implementation of the Operator interface.
 */
package _31_reversePolishNotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author I300939
 */
public class ReversePolishNotationEnh {
    interface Operator {
        int eval(int x, int y);
    }
    
    private static final Map<String, Operator> OPERATORS = new HashMap<String, Operator>() {
        {
            put("+", (Operator) (int x, int y) -> x + y);
            put("-", (Operator) (int x, int y) -> x - y);
            put("*", (Operator) (int x, int y) -> x * y);
            put("/", (Operator) (int x, int y) -> x / y);
        }
    };
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.containsKey(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(OPERATORS.get(token).eval(x, y));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

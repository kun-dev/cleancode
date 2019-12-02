/*
 * Given a string containing just the characters '(',')','{','}','[',']', determine
 * if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * Solution:
 * To validate the parentheses, we need to match each closing parenthesis with its
 * opening counterpart. A Last-In-First-Out (LIFO) data structure such as stack
 * is the perfect fit. As we see an opening parenthesis, we pop the last inserted
 * opening parenthesis from the stack and check if the pair is valid match.
 * It would be wise to avoid writing multiple if statements when matching parentheses,
 * as your interviewer may think that you are writing sloppy code. You could use
 * a map, which is more maintainable.
 */
package _32_validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author I300939
 */
public class ValidParentheses {
    private static final Map<Character, Character> map = new HashMap<Character, Character>(){
        {
            put('(',')');
            put('[',']');
            put('{','}');
        }
    };
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
